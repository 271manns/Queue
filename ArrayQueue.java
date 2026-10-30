@SuppressWarnings("unchecked")
public class ArrayQueue<T> implements QueueInterface<T> 
{
    private T[] log = (T[]) new Object[4];
    private int size;
    private int head;
    private int tail;

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
        if (size == log.length) 
        {
            T[] newLog = (T[]) new Object[log.length * 2];
            for (int i = 0; i < size; i++) 
            {
                newLog[i] = log[(head + i) % log.length];
            }
            log = newLog;
            head = 0;
            tail = size;
        }
        log[tail] = item;
        tail = (tail + 1) % log.length;
        size++;
        return item;
    }

    public T peek() throws QueueUnderflowException {
        if (empty()) 
        {
            throw new QueueUnderflowException();
        }
        return log[head];
    }

    public T remove() throws QueueUnderflowException {
        if (empty()) 
        {
            throw new QueueUnderflowException();
        }

        T item = log[head];
        log[head] = null;
        head = (head + 1) % log.length;
        size--;

        if (log.length > 4 && size <= log.length / 4) 
        {
            T[] newLog = (T[]) new Object[log.length / 2];
            for (int i = 0; i < size; i++) 
            {
                newLog[i] = log[(head + i) % log.length];
            }
            log = newLog;
            head = 0;
            tail = size;
        }
        return item;
    }

    public void clear() {
        log = (T[]) new Object[4];
        size = 0;
        head = 0;
        tail = 0;
    }

    
}