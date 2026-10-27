public class ArrayQueue<T> implements QueueInterface<T>
{
    private int size;
    private T[] log;
    private int front;
    public ArrayQueue()
    {
        log = (T[]) new Object[4];
        size = 0;
        front = 0;
    }
    public int size()
    {
        return size;
    }
    public boolean empty()
    {
        return size == 0;
    }
    public T add(T item)
    {
        if(size == log.length)
        {
            T[] newLog = (T[])new Object[log.length *2];
            for(int i = front ; i<log.length; i++)
            {
                newLog[i] = log[i];
            }
            for(int i = 0; i<front; i++)
            {
                newLog[i] = log[i];
            }
            newLog[size] = item;
            log = newLog;
            size++;
            front = 0;
            return item;
        }
        else
        {
            log[size] = item;
            size++;
            return item;
        }
    }

}