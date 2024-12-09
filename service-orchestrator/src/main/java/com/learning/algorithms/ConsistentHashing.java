package com.learning.algorithms;

import com.learning.models.Node;
import com.learning.models.Request;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;

public class ConsistentHashing implements Router {

    private final Map<Node, List<Long>> nodePositions;
    private final ConcurrentSkipListMap<Long, Node> nodeMappings;
    private final int pointMultiplier;
    private final Function<String, Long> hashfunction;

    public ConsistentHashing(Function<String, Long> hashfunction, int pointMultiplier) {
        if (pointMultiplier == 0)
            throw new IllegalArgumentException();
        this.hashfunction = hashfunction;
        this.pointMultiplier = pointMultiplier;
        this.nodePositions = new ConcurrentHashMap<>();
        this.nodeMappings = new ConcurrentSkipListMap<>();
    }

    @Override
    public void addNode(Node node) {
        nodePositions.put(node, new CopyOnWriteArrayList<>());
        for (int i = 0; i < pointMultiplier; i++) {
            for (int j = 0; j < node.getWeight(); j++) {
                final var point = hashfunction.apply((i * pointMultiplier + j) + node.getId());
                nodePositions.get(node).add(point);
                nodeMappings.put(point, node);
            }
        }
    }

    @Override
    public void removeNode(Node node) {
        for (final Long point : nodePositions.remove(node)) {
            nodeMappings.remove(point);
        }
    }

    @Override
    public Node getAssignedNode(Request request) {
        final var key = hashfunction.apply(request.getId());
        final var entry = nodeMappings.higherEntry(key);
        if (entry == null) {
            return nodeMappings.firstEntry().getValue();
        } else {
            return entry.getValue();
        }
    }
}
