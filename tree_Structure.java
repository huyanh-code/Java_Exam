import java.util.*;

public class tree_Structure {
    public static void main(String[] args) {
        addNode("Personal Documents", Arrays.asList("Home Remodel"));
        addNode("Home Remodel", Arrays.asList("Contractor Contact Info", "Pain Color Scheme", "Flooring woodgrain type", "Kitchen cabinet style"));
        addNode("Work Document", Arrays.asList("XYZ Functional Spec", "Feature Schedule", "Overall Project Plan", "Feature Resources Allocation"));


        System.out.println("Tree Structure");
        printTree("Work Document", " ", true);
        printTree("Personal Documents", "", true);

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter string to search for in the tree:");
        String searchString = scanner.nextLine();
        searchTree(searchString);
    }
    private static Map<String, List<String>> tree = new HashMap<>();

    private static void addNode(String key, List<String> values){
        tree.put(key, values);
    }


    private static void printTree(String root, String indent, boolean isLast){
        System.out.print(indent);
        if (isLast) {
            System.out.print("└── ");
            indent += "    ";
        } else {
            System.out.print("├── ");
            indent += "│   ";
        }
        System.out.println(root);
        List<String> children = tree.get(root);
        if (children != null && !children.isEmpty()) {
            List<String> allChildren = new ArrayList<>(children);
            String lastChild = allChildren.get(allChildren.size() - 1);

            for (String child : allChildren) {
                boolean isLastChild = child.equals(lastChild);
                printTree(child, indent, isLastChild);
            }
        }
    }
    private static void searchTree(String searchString){
        for(Map.Entry<String, List<String>> entry: tree.entrySet()){
            if(entry.getKey().contains(searchString)){
                System.out.println("Node found: " + entry.getKey());
            }
            for (String value: entry.getValue()){
                if(value.contains(searchString)){
                    System.out.println("Node found: " + value);
                }
            }
        }
    }
}