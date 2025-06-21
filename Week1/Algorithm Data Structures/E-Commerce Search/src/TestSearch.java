public class TestSearch {
    public static void main(String[] args) {

        Product[] products = {
                new Product(1, "Shoes", "Footwear"),
                new Product(2, "T-shirt", "Clothing"),
                new Product(3, "Laptop", "Electronics"),
                new Product(4, "Book", "Stationery")
        };

        int searchId = 2;

        Product foundLinear = LinearSearch.search(products, searchId);
        if (foundLinear != null) {
            System.out.println("Linear Search: Found - " + foundLinear.getProductName());
        } else {
            System.out.println("Linear Search: Product not found.");
        }

        // Binary Search Test
        BinarySearch.sortByProductId(products); // IMPORTANT: must sort first

        Product foundBinary = BinarySearch.search(products, searchId);
        if (foundBinary != null) {
            System.out.println("Binary Search: Found - " + foundBinary.getProductName());
        } else {
            System.out.println("Binary Search: Product not found.");
        }
    }
}
