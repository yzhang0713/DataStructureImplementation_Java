import java.util.StringJoiner;

/**
 * This is the implementation of the dynamic list
 */
public class DynamicList implements AbstractList {

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
        if (dataCount - 1 - index >= 0) System.arraycopy(data, index + 1, data, index, dataCount - 1 - index);
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
        if (dataCount >= 0) System.arraycopy(data, 0, copyData, 0, dataCount);
        data = copyData;
    }

    public boolean empty() {
        return this.arrayLength == 0;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",");
        for (int i = 0; i < dataCount; i++) {
            sj.add(Integer.toString(data[i]));
        }
        return sj.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        DynamicList other = (DynamicList) obj;
        if (this.dataCount != other.size()) {
            return false;
        }
        for (int i = 0; i < this.dataCount; i++) {
            if (data[i] != other.get(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int result = 1;
        for (int i = 0; i < this.dataCount; i++) {
            result = prime * result + data[i];
        }
        return result;
    }

}
