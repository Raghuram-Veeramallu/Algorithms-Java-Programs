package PrimsAlgo;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

// Developed on Netbeans MacOS

/*
 *      PROBLEM 2
 *    PRIMS ALGORITHM
 *
 *  Hari Sai Raghuram Veeramallu
 *      1610110145
 */

public class Problem2{

    // Define some constants
    public static final int FIELD_WIDTH = 500;
    public static final int FIELD_HEIGHT = 500;
    public static final int OPER_FLD_HEIGHT = 300;
    private static final int NODE_SIZE = 10;
    
    private JFrame frame;
    private static Graph graph;
    
    private boolean showTotalWeight = true;
    private boolean showEdgeWeight = true;
    
    // Function to create user interface
    public void createUserInterface(){
        
        int numVertices;
        
        // Take number of vertices as input
        try{
            numVertices = Integer.valueOf(JOptionPane.showInputDialog(frame,"Enter number of nodes to be added:"));
        }catch(Exception e){
            // Show error message and exit
            showMessageDialog(null, "Error:" + e.getMessage());
            System.exit(0);
            return;
        }
        
        // Create a new graph object
        graph = new Graph();
        
        // Create a new frame
        frame = new JFrame("Prims's Algorithm");
        // Create an instance of GrpahPanel and set size
        DrawablePanel panel = new DrawablePanel();
        panel.setPreferredSize(new Dimension(FIELD_WIDTH, FIELD_HEIGHT));
        
        // Add a mouse listener to GraphPanel to listen to mouse clicks
        panel.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent ent){
                // Stop listening if the count is reached
                if (graph.getNumberOfNodes() < numVertices){
                    // Add node at mouse clicked location
                    graph.addNewNode(ent.getX(),ent.getY());
                    panel.repaint();
                }else{
                    panel.removeMouseListener(this);
                }
            }
        });
        
        JPanel optionsPanel = new JPanel();
        JPanel inputPanel = new JPanel();
       
        // Field to take input from user
        // Box to hold the JLabel and JTextField
        
        // Source Node
        JLabel source_text = new JLabel("Enter Source Node: ");
        JTextField sourceNode = new JTextField();
        Box sourceBox = Box.createHorizontalBox();
        sourceBox.add(source_text);
        sourceBox.add(sourceNode);
        
        // Destination Node
        JLabel dest_text = new JLabel("Enter Destionation Node: ");
        JTextField destNode = new JTextField();
        Box destBox = Box.createHorizontalBox();
        destBox.add(dest_text);
        destBox.add(destNode);
        
        // Weight of the edge
        JLabel weight_text = new JLabel("Enter Edge Weight: ");
        JTextField edgeWeight = new JTextField();
        Box weightBox = Box.createHorizontalBox();
        weightBox.add(weight_text);
        weightBox.add(edgeWeight);
        
        JButton add_edge = new JButton("Add Edge");
        JButton finish_adding = new JButton("Finish Adding Edges");
        
        // Hold all the components together
        Box inputFields = Box.createVerticalBox();
        inputFields.add(sourceBox);
        inputFields.add(destBox);
        inputFields.add(weightBox);
        inputFields.add(add_edge);
        inputFields.add(finish_adding);
        
        // Add all components to input panel
        inputPanel.add(inputFields);
        
        // Add input panel to optionsPanel
        optionsPanel.add(inputPanel);
        
        // Button Click listner to add edge
        add_edge.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    // Get entered values and create edge
                    int source = Integer.valueOf(sourceNode.getText());
                    int dest = Integer.valueOf(destNode.getText());
                    int weight = Integer.valueOf(edgeWeight.getText());
                    graph.addEdgeBtwNodes((source-1), (dest-1), weight);
                    panel.repaint();
                    // Set the JTextField to empty
                    sourceNode.setText("");
                    destNode.setText("");
                    edgeWeight.setText("");
                }catch(Exception exp){
                    showMessageDialog(null, "Error: "+exp.getMessage());
                }
            }
        });
        
        // Button Click listener for complete adding edges
        finish_adding.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Remove previous panel
                optionsPanel.remove(inputPanel);
                // Create new Panel and add components to it
                JPanel operationsPanel = changeInputToOptions(panel);
                operationsPanel.setPreferredSize(new Dimension(FIELD_WIDTH, OPER_FLD_HEIGHT));
                optionsPanel.add(operationsPanel);
                // Revalidate the parent container to get the new panel
                optionsPanel.revalidate();
            }
        });

        // Split pane to divide the frame into into two halves
        JSplitPane contentSplitPane = new JSplitPane(SwingConstants.HORIZONTAL, panel, optionsPanel);
        // Disable the resize ability of the split frame
        contentSplitPane.setEnabled(false);
        
        // Add the containers to the frame and set the frame visible
        frame.add(contentSplitPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
    // Function to change Input Panel to Options Panel and return new panel
    public JPanel changeInputToOptions(DrawablePanel panel){
        
        // Create operations panel to hold components
        JPanel operationsPanel = new JPanel();
        
        // Button to execute Prims Algorithm and show output
        JButton execPrims = new JButton("Execute Prims");
        execPrims.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // Execute Prim's Algorithm
                graph.executePrimsAlgo();
                showTotalWeight = true;
                panel.repaint();
            }
        });
        
        // Button to reset and create a new graph
        JButton resetBtn = new JButton("Reset");
        resetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
                createUserInterface();
            }
        });
        
        // Toggle between show and hide edge weights
        JButton edgeWgtToggle = new JButton("Hide Weights");
        edgeWgtToggle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // Show weights if not shown else hide weights
                // Use XOR operator change the state 
                showEdgeWeight = showEdgeWeight ^ true;
                showTotalWeight = showTotalWeight ^ true;
                // Change Button text accordingly
                if (edgeWgtToggle.getText().compareTo("Hide Weights") == 0){
                    edgeWgtToggle.setText("Show Weights");
                }else{
                    edgeWgtToggle.setText("Hide Weights");
                }
                panel.repaint();
            }
        });
        
        // Box to hold all components
        Box optionButBox = Box.createVerticalBox();
        optionButBox.add(execPrims);
        optionButBox.add(edgeWgtToggle);
        optionButBox.add(resetBtn);
        
        operationsPanel.add(optionButBox);
        
        return operationsPanel;
    }
    
    // Main function of the class
    public static void main(String[] args){
        Problem2 prim = new Problem2();
        // Entry point for the program
        prim.createUserInterface();
    } 
    
    // Class to paint the JPanel
    class DrawablePanel extends JPanel {
        // Overriting the default paint method
        protected void paintComponent(Graphics graphic) {
            
            // Paint the nodes
            for (int i = 0; i < graph.getNumberOfNodes(); i++) {
                
                // Set the colour of nodes to Black
                graphic.setColor(Color.BLACK);
                Coordinates nodeCoordinates = graph.getCoordPosition(i);
                // The circle must be placed according to radius. The center is at half times the radius.
                graphic.fillOval((nodeCoordinates.getX() - (NODE_SIZE / 2)), (nodeCoordinates.getY() - (NODE_SIZE / 2)), NODE_SIZE, NODE_SIZE);
                
                // Set the colour of node labels to red
                graphic.setColor(Color.RED);
                // As the graph begins labeling the nodes from 0. We use +1 to start from 1.
                graphic.drawString(Integer.toString((i+1)), nodeCoordinates.getX(), (nodeCoordinates.getY() - (NODE_SIZE / 2)));
            }
            
            
            // Paint the edges
            List<Edge> edges = graph.getEdges();
            
            for (int i = 0; i < edges.size() ; i++) {
                
                graphic.setColor(Color.BLUE);
                // Get the positions of the edges
                Coordinates p1 = graph.getCoordPosition(edges.get(i).getSourceVertex());
                Coordinates p2 = graph.getCoordPosition(edges.get(i).getDestVertex());
                
                graphic.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
                
                graphic.setColor(new Color(0,153,0));
                
                // Paint weights if enabled
                if (showEdgeWeight) {
                    // Set the colour to green and obtain weight of the corresponding edge
                    String weight = Integer.toString(edges.get(i).getWeight());
                    // Paint the weights at the center of the line
                    int weightX, weightY;
                    if (p1.getX() > p2.getX()){
                        weightX = p2.getX() + ((p1.getX() - p2.getX()) / 2);
                    }else{
                        weightX = p1.getX() + ((p2.getX() - p1.getX()) / 2);
                    }
                    if (p1.getY() > p2.getY()){
                        weightY = p2.getY() + ((p1.getY() - p2.getY()) / 2);
                    }else{
                        weightY = p1.getY() + ((p2.getY() - p1.getY()) / 2);
                    }
                    graphic.drawChars(weight.toCharArray(), 0, weight.length(), (weightX), (weightY));
                }
            }
            
            // Paint total weight if enabled
            graphic.setColor(new Color(0,153,0));
            if (showTotalWeight){
                graphic.drawString("Total Weight: " + graph.getTotalWeight(), 10, (Problem2.FIELD_WIDTH-10));
            }
        }
    }
    
    // Coordinates class to denote the coordinates in 2D plane
    public class Coordinates {
        private int x,y;
        // Constructor to set the coordinates on create
        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
        // Functions to get particular coordinate
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
    }
    
    // Edge class to denote a edge between two nodes
    public class Edge{
        private int sourceVertex;
        private int destVertex;
        private int edgeWeight;

        // Constructor to create an edge
        public Edge(int sourceVertex, int destVertex, int weight) {
            this.sourceVertex = sourceVertex;
            this.destVertex = destVertex;
            this.edgeWeight = weight;
        }

        // Functions to return source, destination vertices and weights of edges
        public int getSourceVertex() {
            return sourceVertex;
        }
        public int getDestVertex() {
            return destVertex;
        }
        public int getWeight() {
            return edgeWeight;
        }
    }
   
    // EdgeComparator class to compare two edges
    class EdgeComparator implements Comparator<Edge> {
        // Overriding the defalut compare method
        public int compare(Edge edge1, Edge edge2) {
            return (int)(edge1.getWeight() - edge2.getWeight());
        }
    }
    
    
    // Class Graph which contains all the functions related to graph and 
    // all structures of nodes and edges.
    public class Graph {
        
        // List of nodes. Each node is represented by a pair of coordinates
        private List<Coordinates> positions = new ArrayList<Coordinates>();
        // List of edges
        private List<Edge> edges = new ArrayList<Edge>();
        
        // Function to add a vertex
        public void addNewNode(int x, int y) {
            positions.add(new Coordinates(x, y));
        }
        
        // Function to add an edge between two nodes
        public void addEdgeBtwNodes(int node1, int node2, int weight) {
            if (getEdge(node1, node2) == null){
                edges.add(new Edge(node1, node2, weight));
            }    
        }
        
        // Get the coordinates of a vertex
        public Coordinates getCoordPosition(int node) {
            return positions.get(node);
        }

        // Get Number of Nodes
        public int getNumberOfNodes() {
            return positions.size();
        }

        // Get number of edges
        public int getNumberOfEdges() {
            return edges.size();
        }

        // Get the list of edges
        public List<Edge> getEdges() {
            return edges;
        }
        
        // Get the weight of the edge
        public int getWeight(int node1, int node2) {
            // Check if there is an edge between the two nodes
            Edge edge = getEdge(node1, node2);
            if (edge == null){
                throw new RuntimeException();
            }
            // else return weight
            return edge.getWeight();
        }
        
        // Calculate the total weight of the graph
        public int getTotalWeight() {
            int totalWeight = 0;
            for (int i = 0 ; i < edges.size() ; i++){
                totalWeight = totalWeight + edges.get(i).getWeight();
            }
            return totalWeight;
        }

        // Find the edge between two nodes
        public Edge getEdge(int node1, int node2) {
            for (int i = 0 ; i < edges.size(); i++) {
                // Check if there is any edge between the two nodes else return null    
                if ((edges.get(i).getSourceVertex() == node1 && edges.get(i).getDestVertex() == node2) || (edges.get(i).getSourceVertex() == node2 && edges.get(i).getDestVertex() == node1)){
                    return edges.get(i);
                }
            }
            return null;
        }        

        // Function to find surrounding nodes from the present nodes
        public List<Integer> getNeighbours(int node) {
            // List of nodes surrounding the current node
            List<Integer> connectedVertices = new ArrayList<>();

            // Check the edge corresponding source and destination nodes to find if any node is neighbour
            for (int i = 0 ; i < edges.size() ; i++) {
                if (edges.get(i).getSourceVertex() == node){
                    connectedVertices.add(edges.get(i).getDestVertex());
                }else if (edges.get(i).getDestVertex() == node){
                    connectedVertices.add(edges.get(i).getSourceVertex());
                }
            }

            return connectedVertices;
        }

        // Function to find all the edges to which the node is connected
        public List<Edge> getEdgesConnectedTo(int node) {
            // List of edges the node is connected
            List<Edge> edgesConnected = new ArrayList<>();
            for (int i = 0 ; i < edges.size() ; i++){
                if (edges.get(i).getSourceVertex() == node){
                    edgesConnected.add(edges.get(i));
                }else if(edges.get(i).getDestVertex() == node){
                    edgesConnected.add(edges.get(i));
                }
            }
            return edgesConnected;
        }
        
        // Prims Algorithm
        public void executePrimsAlgo() {
           
            // If there are no nodes then return 
            if (getNumberOfNodes() < 1){
                return;
            }
            
            // Lists to store final edges and used nodes
            List<Edge> requiredEdges = new ArrayList<>();
            List<Integer> exhaustedNodes = new ArrayList<>();
            
            // Start Node as 0
            exhaustedNodes.add(0);
            
            // List of neighbour nodes
            List<Edge> neighbours = new ArrayList<>();
            
            // Execute until all nodes are covered
            while (exhaustedNodes.size() < getNumberOfNodes()) {
                
                boolean edgeFound = false;
                
                // Add all neighbours and find the least cost edge to consider all possible costs
                neighbours.addAll(getEdgesConnectedTo(exhaustedNodes.get(exhaustedNodes.size() - 1)));
                // Sort the edges according to costs
                Collections.sort(neighbours, new EdgeComparator());

                
                for (int i = 0; i < neighbours.size() ; i++) {
                    // If the edge to a node is not used to go to that node
                    if (exhaustedNodes.contains(neighbours.get(i).getSourceVertex()) && !exhaustedNodes.contains(neighbours.get(i).getDestVertex())) {
                        requiredEdges.add(neighbours.get(i));
                        exhaustedNodes.add(neighbours.get(i).getDestVertex());
                        edgeFound = true;
                        break;
                    }
                    else if (exhaustedNodes.contains(neighbours.get(i).getDestVertex()) && !exhaustedNodes.contains(neighbours.get(i).getSourceVertex())){
                        requiredEdges.add(neighbours.get(i));
                        exhaustedNodes.add(neighbours.get(i).getSourceVertex());
                        edgeFound = true;
                        break;
                    }
                }
                
                // If no edge is found exit the loop
                if (!edgeFound){
                    break;
                }
            }
            
            // Clear the present edges and add the computed edges from prims
            edges.clear();
            edges.addAll(requiredEdges);
           
        }         
        
    }
}