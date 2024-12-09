package com.learning.algorithms;

import com.learning.models.Node;
import com.learning.models.Request;

public interface Router {
    void addNode(Node node);
    void removeNode(Node node);
    Node getAssignedNode(Request request);
}
