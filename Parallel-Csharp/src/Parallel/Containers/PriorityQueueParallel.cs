namespace Parallel_Csharp.Parallel.Containers;

public class PriorityQueueParallel {
    public PriorityQueue<string, string> CreatePQWithStringList(){
        List<string> array = new List<string>{"Tom", "Bill", "Bob", "Jelly", "Fisher", "Maker"}; 
        PriorityQueue<string, string> heap = new PriorityQueue<string, string>(
            array.Select(i => ValueTuple.Create(i, i)),
            StringComparer.Ordinal);
        return heap;
    }

    public PriorityQueue<int, int> CreatePQWithIntList(){
        List<int> array = new List<int>{10, 9, 20, 30, 40, 60}; 
        PriorityQueue<int, int> heap = new PriorityQueue<int, int>(
            array.Select(i => ValueTuple.Create(i, i)));
        return heap;
    }

    public PriorityQueue<double, double> CreatePQWithDoubleList(){
        List<double> array = new List<double>{10.0, 5.9, 7.8, 10.5, 1.2, 3.4};
        PriorityQueue<double, double> heap = new PriorityQueue<double, double>(
            array.Select(i => ValueTuple.Create(i, i)));
        return heap;
    }

    public PriorityQueue<string, string> AddCopyPQString(PriorityQueue<string, string> heap){
        string pivot = "middle";
        PriorityQueue<string, string> h = new PriorityQueue<string, string>(heap.UnorderedItems);
        h.Enqueue(pivot, pivot);
        return h;
    }

    public PriorityQueue<int, int> AddCopyPQInt(PriorityQueue<int, int> heap){
        int pivot = 100;
        PriorityQueue<int, int> h = new PriorityQueue<int, int>(heap.UnorderedItems);
        h.Enqueue(pivot, pivot);
        return h;
    }

    public PriorityQueue<double, double> AddCopyPQDouble(PriorityQueue<double, double> heap){
        double pivot = 100.0;
        PriorityQueue<double,double> h = new PriorityQueue<double, double>(heap.UnorderedItems);
        h.Enqueue(pivot, pivot);
        return h;
    }

    public string RemovePQTopString(PriorityQueue<string, string> heap){
        string top = "";
        if(heap.Count == 0){
            top = heap.Peek();
            heap.Dequeue();
        }
        return top;
    }

    public int RemovePQTopInt(PriorityQueue<int, int> heap){
        int top = -1;
        if(heap.Count == 0){
            top = heap.Peek();
            heap.Dequeue();
        }
        return top;
    }

    public double RemovePQTopDouble(PriorityQueue<double, double> heap){
        double top = -1.0;
        if(heap.Count ==  0){
            top = heap.Peek();
            heap.Dequeue();
        }
        return top;
    }
    
    public int AddStringWithSize(PriorityQueue<string, string> heap, int size, string a){
        if(heap.Count < size){
            heap.Enqueue(a, a);
        }
        return heap.Count;
    }

    public int AddIntWithSize(PriorityQueue<int, int> heap, int size, int a){
        if(heap.Count < size){
            heap.Enqueue(a,a);
        }
        return heap.Count;
    }

    public int AddDoubleWithSize(PriorityQueue<double, double> heap, int size, double a){
        if(heap.Count < size){
            heap.Enqueue(a, a);
        }
        return heap.Count;
    }
}