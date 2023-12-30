public class Student<T> implements IDatabase<T>{

    @Override
    public boolean insert(T data) {
        return true;
    }

    @Override
    public boolean delete(T data) {
        return true;
    }

    @Override
    public boolean update(T data) {
        return true;
    }

    @Override
    public T fetch() {
        return null;
    }
}
