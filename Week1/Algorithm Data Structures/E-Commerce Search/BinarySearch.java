import java.util.Arrays;
import java.util.Comparator;
public class BinarySearch {
    public static void sortByProductId(Product[] products) {
        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));
    }

    public static Product search(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midId = products[mid].getProductId();

            if (midId == targetId) {
                return products[mid];
            } else if (midId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null; // Not found
    }
}
