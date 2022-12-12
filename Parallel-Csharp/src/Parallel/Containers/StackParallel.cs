namespace Parallel_Csharp.Parallel.Containers;

public class StackParallel {
    // template 1, initialize with list
    public Stack<char> GetStackWithCharList(List<char> list)
    {
        Stack<char> stack = new Stack<char>(list);
        return stack;
    }
    
    public Stack<string> GetStackWithStringList(List<string> list)
    {
        Stack<string> stack = new Stack<string>(list);
        return stack;
    }
    
    public Stack<int> GetStackWithIntList(List<int> list)
    {
        Stack<int> stack = new Stack<int>(list);
        return stack;
    }
    
    public Stack<double> GetStackWithDoubleList(List<double> list)
    {
        Stack<double> stack = new Stack<double>(list);
        return stack;
    }
    
    //Template 2, clear if not empty
    public void MakeEmptyChar(Stack<char> stack){
        if(stack.Count != 0){
            stack.Clear();
        }
    }

    // Convert Char to String
    public void MakeEmptyString(Stack<string> stack){
        if(stack.Count != 0){
            stack.Clear();
        }
    }
    
    // Convert Char to Int
    public void MakeEmptyInt(Stack<int> stack){
        if(stack.Count != 0){
            stack.Clear();
        }
    }
    
    // Convert Char to Double
    public void MakeEmptyDouble(Stack<double> stack){
        if(stack.Count != 0){
            stack.Clear();
        }
    }
    
    // Template 3, pop until greater than or less than element
    public void FindGreaterChar(Stack<char> stack, char element){
        while(stack.Count != 0){
            char c = stack.Peek();
            if(c < element){
                stack.Pop();
                return;
            }
        }
    }

    public void FindLessChar(Stack<char> stack, char element){
        while(stack.Count != 0){
            char c = stack.Peek();
            if(c > element){
                stack.Pop();
                return;
            }
        }
    }
    
    public void FindEqualChar(Stack<char> stack, char element){
        while(stack.Count == 0){
            char c = stack.Peek();
            if(c > element){
                stack.Pop();
                return;
            }
        }
    }

    // todo Convert Char to String
    public void FindGreaterString(Stack<String> stack, String element){
        while(stack.Count != 0){
            String c = stack.Peek();
            if(c.CompareTo(element) < 0){
                stack.Pop();
                return;
            }
        }
    }

    public void FindLessString(Stack<String> stack, String element){
        while(stack.Count != 0){
            String c = stack.Peek();
            if(c.CompareTo(element) > 0){
                stack.Pop();
                return;
            }
        }
    }
    
    public void FindEqualString(Stack<String> stack, String element){
        while(stack.Count == 0){
            String c = stack.Peek();
            if(c.CompareTo(element) == 0){
                stack.Pop();
                return;
            }
        }
    }

    // todo Convert Char to Int
    public void FindGreaterInt(Stack<int> stack, int element){
        while(stack.Count != 0){
            int c = stack.Peek();
            if(c < element){
                stack.Pop();
                return;
            }
        }
    }

    public void FindLessInt(Stack<int> stack, int element){
        while(stack.Count != 0){
            int c = stack.Peek();
            if(c > element){
                stack.Pop();
                return;
            }
        }
    }
    
    public void FindEqualInt(Stack<int> stack, int element){
        while(stack.Count == 0){
            int c = stack.Peek();
            if(c > element){
                stack.Pop();
                return;
            }
        }
    }

    // todo Convert Char to Double
    public void FindGreaterDouble(Stack<double> stack, double element){
        while(stack.Count != 0){
            double c = stack.Peek();
            if(c < element){
                stack.Pop();
                return;
            }
        }
    }

    public void FindLessDouble(Stack<double> stack, double element){
        while(stack.Count != 0){
            double c = stack.Peek();
            if(c > element){
                stack.Pop();
                return;
            }
        }
    }
    
    public void FindEqualDouble(Stack<double> stack, double element){
        while(stack.Count == 0){
            double c = stack.Peek();
            if(c > element){
                stack.Pop();
                return;
            }
        }
    }

    // Template 4, push list
    public void PushListChar(Stack<char> stack, List<char> list){
        if(list.Count == 0) return;
        foreach(char c in list){
            stack.Push(c);
        }
    }

    // Convert Char to String
    public void PushListString(Stack<string> stack, List<string> list){
        if(list.Count == 0) return;
        foreach(string c in list){
            stack.Push(c);
        }
    }
    
    // Convert Char to Int
    public void PushListInt(Stack<int> stack, List<int> list){
        if(list.Count == 0) return;
        foreach(int c in list){
            stack.Push(c);
        }
    }
    
    // Convert Char to Double
    public void PushListDouble(Stack<double> stack, List<double> list){
        if(list.Count == 0) return;
        foreach(double c in list){
            stack.Push(c);
        }
    }
    
    //Template 5, pop and equal
    public bool PopEqualChar(Stack<char> stack1, Stack<char> stack2){
        if(stack1.Count == 0) return false;
        else stack1.Pop();
        bool b = stack1.SequenceEqual(stack2);
        return b;
    }

    // Convert Char to String
    public bool PopEqualString(Stack<string> stack1, Stack<string> stack2){
        if(stack1.Count == 0) return false;
        else stack1.Pop();
        bool b = stack1.SequenceEqual(stack2);
        return b;
    }
    
    // Convert Char to Int
    public bool PopEqualInt(Stack<int> stack1, Stack<int> stack2){
        if(stack1.Count == 0) return false;
        else stack1.Pop();
        bool b = stack1.SequenceEqual(stack2);
        return b;
    }
    
    // Convert Char to Double
    public bool PopEqualDouble(Stack<double> stack1, Stack<double> stack2){
        if(stack1.Count == 0) return false;
        else stack1.Pop();
        bool b = stack1.SequenceEqual(stack2);
        return b;
    }
}