using Parallel.Entity;

namespace Parallel.Base;

public class Global
{
    private EntityCollection _globalEntityCollection;

    public EntityCollection GlobalEntityCollection => _globalEntityCollection;

    private static Global? _instance;

    private Global()
    {
        _globalEntityCollection = new EntityCollection();
    }

    public static int GenerateEntityId()
    {
        return 1;
    }
    public static Global Instance
    {
        get
        {
            if (_instance == null)
                _instance = new Global();
            return _instance;
        }
    }
}