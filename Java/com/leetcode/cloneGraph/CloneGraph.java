package com.leetcode.cloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import com.leetcode.dataStructures.UndirectedGraphNode;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
        if(node.neighbors.size() == 0)
            return new UndirectedGraphNode(node.label);
        // Map using track the accessed nodes
        HashMap<UndirectedGraphNode, UndirectedGraphNode> nodeMapping = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        // Queue using to track the possiblly unaccessed children
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        UndirectedGraphNode graph = new UndirectedGraphNode(node.label);
        
        nodeMapping.put(node, graph);
        
        while(queue.size() != 0){
            // If this node hasn't been accessed, then add all its children to the queue and copy it.
            UndirectedGraphNode g1 = queue.pop();
            // Get node copy
            UndirectedGraphNode g2 = nodeMapping.get(g1);
            ArrayList<UndirectedGraphNode> neighbors = (ArrayList<UndirectedGraphNode>)g1.neighbors;
            for(UndirectedGraphNode neighbor : neighbors){
                if(nodeMapping.containsKey(neighbor)){
                    g2.neighbors.add(nodeMapping.get(neighbor));
                }
                else{
                    UndirectedGraphNode single = new UndirectedGraphNode(neighbor.label);
                    nodeMapping.put(neighbor, single);
                    queue.add(neighbor);
                    g2.neighbors.add(single);
                }
            }
        }
            
        return graph;    
            
        
    }
}
