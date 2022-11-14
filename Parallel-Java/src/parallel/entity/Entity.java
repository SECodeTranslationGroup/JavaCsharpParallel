package parallel.entity;

import parallel.base.Global;
import parallel.vector.Vector3;

public class Entity {
    private int id;

    private EntityType type;

    private EntityFaction faction;

    private Vector3 pos;

    private double maxHealth;

    private double currentHealth;

    private Entity()
    {
        id = Global.GenerateEntityId();
        type = EntityType.SUMMONED;
        faction = EntityFaction.NEUTRAL;
        maxHealth = 10;
        currentHealth = 10;
        pos = new Vector3(0, 0, 0);
    }

    public static Entity create(EntityType type, EntityFaction fac, Vector3 pos, double health)
    {
        var entity = new Entity();
        entity.type = type;
        entity.faction = fac;
        entity.pos = pos;
        entity.maxHealth = health;
        entity.currentHealth = health;
        Global.getInstance().getGlobalEntityCollection().addEntity(entity);
        return entity;
    }

    public int getId() {
        return id;
    }

    public EntityType getType() {
        return type;
    }

    public void setType(EntityType type) {
        this.type = type;
    }

    public EntityFaction getFaction() {
        return faction;
    }

    public void setFaction(EntityFaction faction) {
        this.faction = faction;
    }

    public Vector3 getPos() {
        return pos;
    }

    public void setPos(Vector3 pos) {
        this.pos = pos;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    public double getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(double currentHealth) {
        this.currentHealth = currentHealth;
    }

    public static EntityFaction getOppositeFaction(EntityFaction fac)
    {
        if (fac == EntityFaction.COOL_SIDE)
            return EntityFaction.WARM_SIDE;
        if (fac == EntityFaction.WARM_SIDE)
            return EntityFaction.COOL_SIDE;
        return fac;
    }

    public void takeDamage(double damageAmount) {
    }
}
