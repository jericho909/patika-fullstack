import java.util.*;
public class MyList <T>{
    private T[] arr;
    private int arrSize;
    private int arrCapacity;

    public MyList(){
        this.arrCapacity = 10;
        this.arr = (T[]) new Object[this.arrCapacity];
        this.arrSize = 0;
    }

    public MyList(int sizeOfArray){
        this.arrCapacity = sizeOfArray;
        this.arr = (T[]) new Object[this.arrCapacity];
        this.arrSize = 0;
    }

    public T[] getArr() {
        return arr;
    }

    public void setArr(T[] arr) {
        this.arr = arr;
    }

    public int getArrSize() {
        return arrSize;
    }

    public void setArrSize(int arrSize) {
        this.arrSize = arrSize;
    }

    public int getArrCapacity() {
        return arrCapacity;
    }

    public void setArrCapacity(int arrCapacity) {
        this.arrCapacity = arrCapacity;
    }

    public void add(T newData){
        if (this.arrSize == this.arrCapacity){
            resizeArray();
        }
        this.arr[this.arrSize] = newData;
        this.arrSize++;
    }

    public void resizeArray(){
        this.arrCapacity *= 2;
        T[] newArr = (T[]) new Object[this.arrCapacity];

        for(int i = 0; i < this.arrSize; i++){
            newArr[i] = this.arr[i];
        }

        this.arr = newArr;
    }

    public T get(int index){
        if (index >= this.arrSize || index < 0){
            return null;
        } else {
            return arr[index];
        }
    }

    public T remove(int index) {
        if (index < 0 || index >= arrSize) {
            return null;
        }

        T removedItem = arr[index];

        for (int i = index; i < arrSize - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[arrSize - 1] = null;

        arrSize--;

        return removedItem;
    }


    public void set(int index, T data){
        if (index >= this.arrSize || index < 0){
            System.out.println("null");
        } else {
            arr[index] = data;
        }
    }
    @Override
    public String toString(){
        for(T element: arr){
            if (element != null){
                System.out.println(element);
            }
        }
        return null;
    }
    public int indexOf(T data) {
        for (int i = 0; i < arrSize; i++) {
            if (arr[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        for (int i = arrSize - 1; i >= 0; i--) {
            if (arr[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return arrSize == 0;
    }

    public T[] toArray() {
        return Arrays.copyOf(arr, arrSize);
    }

    public void clear() {
        Arrays.fill(arr, null);
        arrSize = 0;
    }

    public MyList<T> sublist(int start, int finish) {
        if (start < 0 || finish >= arrSize || start > finish) {
            throw new IllegalArgumentException("Geçersiz indeks aralığı");
        }
        MyList<T> sub = new MyList<>(finish - start + 1);
        for (int i = start; i <= finish; i++) {
            sub.add(arr[i]);
        }
        return sub;
    }

    public boolean contains(T data) {
        return indexOf(data) != -1;
    }


}
