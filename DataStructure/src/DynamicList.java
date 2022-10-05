import java.util.StringJoiner;

/**
 * This is the implementation of the dynamic list
 */
public class DynamicList {

    private int[] data;
    private int dataCount;
    private int arrayLength = 8;

    // Constructor
    public DynamicList() {
        data = new int[arrayLength];
        dataCount = 0;
    }

    // Method to get size of dynamic list
    public int size() {
        return dataCount;
    }

    // Method to insert an element into dynamic list
    public void insert(int x) {
        if (dataCount == arrayLength) {
            // The static array is full, need to expand the array by doubling its size
            arrayLength *= 2;
            resize(arrayLength);
        }
        data[dataCount] = x;
        dataCount++;
    }

    // Method to retrieve a random element from the list
    public int get(int index) {
        if (index >= dataCount) {
            throw new RuntimeException("Index exceeds the upper limit of the dynamic list");
        }
        return data[index];
    }

    // Method to remove a random element from the list
    public int remove(int index) {
        if (index >= dataCount) {
            throw new RuntimeException("Index exceeds the upper limit of the dynamic list");
        }
        int temp = data[index];
        for (int i = index; i < dataCount-1; i++) {
            data[i] = data[i+1];
        }
        dataCount--;
        if (dataCount <= arrayLength/4) {
            // The static array is too empty, need to shrink the array by half
            arrayLength /= 2;
            resize(arrayLength);
        }
        return temp;
    }

    // Clear all data in list
    public void clear() {
        dataCount = 0;
        arrayLength = 8;
        data = new int[arrayLength];
    }

    // Helper method to resize the array
    private void resize(int updatedSize) {
        int[] copyData = new int[updatedSize];
        for (int i = 0; i < dataCount; i++) {
            copyData[i] = data[i];
        }
        data = copyData;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",");
        for (int i = 0; i < dataCount; i++) {
            sj.add(Integer.toString(data[i]));
        }
        return sj.toString();
    }

}
