using Parallel.Base;
using Parallel.Vector;

namespace Parallel.Entity;

public class Entity
{
    private int _id;

    public int Id => _id;

    private EntityType _type;

    private EntityFaction _faction;

    private Vector3 _pos;

    private double _maxHealth;

    private double _currentHealth;

    private Entity()
    {
        _id = Global.GenerateEntityId();
        _type = EntityType.Summoned;
        _faction = EntityFaction.Neutral;
        _maxHealth = 10;
        _currentHealth = 10;
        _pos = new Vector3(0, 0, 0);
    }

    public static Entity Create(EntityType type, EntityFaction fac, Vector3 pos, double health)
    {
        var entity = new Entity();
        entity._type = type;
        entity._faction = fac;
        entity._pos = pos;
        entity._maxHealth = health;
        entity._currentHealth = health;
        Global.Instance.GlobalEntityCollection.AddEntity(entity);
        return entity;
    }
    
    public Vector3 Pos
    {
        get => _pos;
        set => _pos = value;
    }
    

    public double MaxHealth
    {
        get => _maxHealth;
        set => _maxHealth = value;
    }

    public double CurrentHealth
    {
        get => _currentHealth;
        set => _currentHealth = value;
    }

    public EntityFaction Faction
    {
        get => _faction;
        set => _faction = value;
    }

    public EntityType Type
    {
        get => _type;
        set => _type = value;
    }

    public static EntityFaction GetOppositeFaction(EntityFaction fac)
    {
        if (fac == EntityFaction.CoolSide)
            return EntityFaction.WarmSide;
        if (fac == EntityFaction.WarmSide)
            return EntityFaction.CoolSide;
        return fac;
    }

    public void TakeDamage(double damageAmont)
    {
        
    }
}