namespace Parallel_Csharp.Parallel.Containers;

public class QueueParallel {
    // T1
    public Queue<char> GetQueueChar(){
        Queue<char> queue = new Queue<char>();
        for(int i=0; i<10; ++i){
            queue.Enqueue('c');
        }
        return queue;
    }
    
    // Convert Char to String
    public Queue<string> GetQueueString(){
        Queue<string> queue = new Queue<string>();
        for(int i=0; i<10; ++i){
            queue.Enqueue("aa");
        }
        return queue;
    } 
    
    // Convert Char to Int
    public Queue<int> GetQueueInt(){
        Queue<int> queue = new Queue<int>();
        for(int i=0; i<10; ++i){
            queue.Enqueue('c');
        }
        return queue;
    }
    
    // Convert Char to Double
    public Queue<double> GetQueueDouble(){
        Queue<double> queue = new Queue<double>();
        for(int i=0; i<10; ++i){
            queue.Enqueue('c');
        }
        return queue;
    }
    
    // T2
    public Queue<char> CopyAddChar(Queue<char> queue, char c){
        Queue<char> q = new Queue<char>(queue);
        q.Enqueue(c);
        return q;
    }
    
    // Convert Char to String
    public Queue<string> CopyAddString(Queue<string> queue, string c){
        Queue<string> q = new Queue<string>(queue);
        q.Enqueue(c);
        return q;
    }
    
    // Convert Char to Int
    public Queue<int> CopyAddInt(Queue<int> queue, int c){
        Queue<int> q = new Queue<int>(queue);
        q.Enqueue(c);
        return q;
    }
    
    // todo Convert Char to Double
    public Queue<double> CopyAddDouble(Queue<double> queue, double c){
        Queue<double> q = new Queue<double>(queue);
        q.Enqueue(c);
        return q;
    }
    
    // T3
    public Queue<char> ToLengthChar(Queue<char> queue, int length){
        int size = queue.Count;
        while(size < length){
            size++;
            queue.Enqueue('a');
        }
        return queue;
    }
    
    // Convert Char to String
    public Queue<string> ToLengthString(Queue<string> queue, int length){
        int size = queue.Count;
        while(size < length){
            size++;
            queue.Enqueue("aa");
        }
        return queue;
    }
    
    // Convert Char to Int
    public Queue<int> ToLengthInt(Queue<int> queue, int length){
        int size = queue.Count;
        while(size < length){
            size++;
            queue.Enqueue('a');
        }
        return queue;
    }
    
    // Convert Char to Double
    public Queue<double> ToLengthDouble(Queue<double> queue, int length){
        int size = queue.Count;
        while(size < length){
            size++;
            queue.Enqueue('a');
        }
        return queue;
    }
    
    // T4
    public string AddTwoChar(Queue<char> queue){
        char a = queue.Dequeue();
        char b = queue.First();
        queue.Enqueue(a);
        string str = "";
        str += a;
        str += b;
        return str;
    }
    
    // Convert Char to String
    public string AddTwoString(Queue<string> queue){
        string a = queue.Dequeue();
        string b = queue.First();
        queue.Enqueue(a);
        string str = "";
        str += a;
        str += b;
        return str;
    }
    
    // todo Convert Char to Int
    public int AddTwoInt(Queue<int> queue){
        int a = queue.Dequeue();
        int b = queue.First();
        queue.Enqueue(a);
        int str = 0;
        str += a;
        str += b;
        return str;
    }
    
    // todo Convert Char to Double
    public double AddTwoDouble(Queue<double> queue){
        double a = queue.Dequeue();
        double b = queue.First();
        queue.Enqueue(a);
        double str = 0.0;
        str += a;
        str += b;
        return str;
    }
    
    // T5
    public string AddAllChar(Queue<char> queue){
        string str = "";
        while(queue.Count != 0){
            str += queue.Dequeue();
        }
        return str;
    }
    
    // Convert Char to String
    public string AddAllString(Queue<string> queue){
        string str = "";
        while(queue.Count != 0){
            str += queue.Dequeue();
        }
        return str;
    }
    
    // todo Convert Char to Int
    public int AddAllInt(Queue<int> queue){
        int str = 0;
        while(queue.Count != 0){
            str += queue.Dequeue();
        }
        return str;
    }
    
    // Convert Char to Double
    public double AddAllDouble(Queue<double> queue){
        double str = 0;
        while(queue.Count != 0){
            str += queue.Dequeue();
        }
        return str;
    }
    
    // T6
    public Queue<char> ConcatQueueChar(Queue<char> queue1, Queue<char> queue2){
        Queue<char> queue = new Queue<char>(queue1);
        Queue<char> tmp = new Queue<char>(queue2);
        while(tmp.Count != 0){
            char c = tmp.Dequeue();
            queue.Enqueue(c);
        }
        tmp.Clear();
        return queue;
    }
    
    // Convert Char to String
    public Queue<string> ConcatQueueString(Queue<string> queue1, Queue<string> queue2){
        Queue<string> queue = new Queue<string>(queue1);
        Queue<string> tmp = new Queue<string>(queue2);
        while(tmp.Count != 0){
            string c = tmp.Dequeue();
            queue.Enqueue(c);
        }
        tmp.Clear();
        return queue;
    }
    
    // todo Convert Char to Int
    public Queue<int> ConcatQueueInt(Queue<int> queue1, Queue<int> queue2){
        Queue<int> queue = new Queue<int>(queue1);
        Queue<int> tmp = new Queue<int>(queue2);
        while(tmp.Count != 0){
            int c = tmp.Dequeue();
            queue.Enqueue(c);
        }
        tmp.Clear();
        return queue;
    }
    
    // todo Convert Char to Double
    public Queue<double> ConcatQueueDouble(Queue<double> queue1, Queue<double> queue2){
        Queue<double> queue = new Queue<double>(queue1);
        Queue<double> tmp = new Queue<double>(queue2);
        while(tmp.Count != 0){
            double c = tmp.Dequeue();
            queue.Enqueue(c);
        }
        tmp.Clear();
        return queue;
    }
    
    // T7
    public void DismissQueueChar(Queue<char> queue1, Queue<char> queue2){
        while(queue1.Count != 0 && queue2.Count != 0){
            char c1 = queue1.First();
            char c2 = queue2.First();
            if(c1 != c2) return;
            else{
                queue1.Dequeue();
                queue2.Dequeue();
            }
        }
    }
    
    // Convert Char to String
    public void DismissQueueString(Queue<string> queue1, Queue<string> queue2){
        while(queue1.Count != 0 && queue2.Count != 0){
            string c1 = queue1.First();
            string c2 = queue2.First();
            if(c1.CompareTo(c2) != 0) return;
            else{
                queue1.Dequeue();
                queue2.Dequeue();
            }
        }
    }
    
    // Convert Char to Int
    public void DismissQueueInt(Queue<int> queue1, Queue<int> queue2){
        while(queue1.Count != 0 && queue2.Count != 0){
            int c1 = queue1.First();
            int c2 = queue2.First();
            if(c1 != c2) return;
            else{
                queue1.Dequeue();
                queue2.Dequeue();
            }
        }
    }
    
    // Convert Char to Double
    public void DismissQueueDouble(Queue<double> queue1, Queue<double> queue2){
        while(queue1.Count != 0 && queue2.Count != 0){
            double c1 = queue1.First();
            double c2 = queue2.First();
            if(c1 != c2) return;
            else{
                queue1.Dequeue();
                queue2.Dequeue();
            }
        }
    }
    
    // T8
    public bool HeadTailEqualChar(Queue<char> queue){
        char c1 = queue.First();
        char c2 = queue.Last();
        if(c1 == c2) return true;
        else return false;
    }
        
    // Convert Char to String
    public bool HeadTailEqualString(Queue<string> queue){
        string c1 = queue.First();
        string c2 = queue.Last();
        if(c1.CompareTo(c2) == 0) return true;
        else return false;
    }
    
    // Convert Char to Int
    public bool HeadTailEqualInt(Queue<int> queue){
        int c1 = queue.First();
        int c2 = queue.Last();
        if(c1 == c2) return true;
        else return false;
    }
    
    // todo Convert Char to Double
    public bool HeadTailEqualDouble(Queue<double> queue){
        double c1 = queue.First();
        double c2 = queue.Last();
        if(c1 == c2) return true;
        else return false;
    }
    
    // T9
    public bool EqualQueueChar(Queue<char> queue1, Queue<char> queue2){
        if(queue1.Count != queue2.Count) return false;
        else return queue1.SequenceEqual(queue2);
    }
    
    // Convert Char to String
    public bool EqualQueueString(Queue<string> queue1, Queue<string> queue2){
        if(queue1.Count != queue2.Count) return false;
        else return queue1.SequenceEqual(queue2);
    }
    
    // Convert Char to Int
    public bool EqualQueueInt(Queue<int> queue1, Queue<int> queue2){
        if(queue1.Count != queue2.Count) return false;
        else return queue1.SequenceEqual(queue2);
    }
    
    // Convert Char to Double
    public bool EqualQueueDouble(Queue<double> queue1, Queue<double> queue2){
        if(queue1.Count != queue2.Count) return false;
        else return queue1.SequenceEqual(queue2);
    }
}