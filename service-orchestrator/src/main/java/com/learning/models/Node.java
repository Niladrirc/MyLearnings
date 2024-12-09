package com.learning.models;

import java.util.Objects;

public class Node {
    private final String id;
    private final int weight;
    private final String ipAddress;

    public Node(String id, int weight, String ipAddress) {
        this.id = id;
        this.weight = weight;
        this.ipAddress = ipAddress;
    }

    public Node(String id, String ipAddress) {
        this(id, 1, ipAddress);
    }

    public String getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Node node = (Node) obj;
        return id.equals(node.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
