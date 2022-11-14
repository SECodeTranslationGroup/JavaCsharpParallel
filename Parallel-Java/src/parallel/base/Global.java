package parallel.base;

import parallel.entity.EntityCollection;

public class Global {
    private EntityCollection globalEntityCollection;

    public EntityCollection getGlobalEntityCollection() {
        return globalEntityCollection;
    }
    private static Global instance;

    private Global() {
        globalEntityCollection = new EntityCollection();
    }

    public static int GenerateEntityId() {
        return 1;
    }

    public static Global getInstance() {
        if (instance == null)
            instance = new Global();
        return instance;
    }
}