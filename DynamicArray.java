import java.util.Arrays;

class DynamicArray {
    private int Default_Lenght = 10;
    private Object[] array;
    private int size;

    public DynamicArray() {
        this.array = new Object[Default_Lenght];
        this.size = 0;
    }

    public void add(Object object) {
        ensureStorageOfArr();
        array[size++] = object;
    }

    public Object get(int index) {
        return array[index];
    }

    public int size () {
        return size;
    }

    public void remove () {
        if (size > 0) {
            array[--size] = null;
        }
    }

    public void remove(int index) {
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
    }

    public void set(int index, Object object) {
        array[index] = object;
    }

    public void clear() {
        array = new Object[Default_Lenght];
        size = 0;
    }

    private void ensureStorageOfArr() {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();

        dynamicArray.add("1");
        dynamicArray.add("2");
        dynamicArray.add("3");

        System.out.println("Size: " + dynamicArray.size());
        System.out.println("index 1: " + dynamicArray.get(1));
        dynamicArray.remove();
        System.out.println("removed element" + dynamicArray.size());
        System.out.println(dynamicArray.get(2));
        dynamicArray.add("4");
        System.out.println(dynamicArray.get(2));
        System.out.println(dynamicArray.size());
    }

}