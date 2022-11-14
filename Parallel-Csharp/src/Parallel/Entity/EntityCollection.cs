using System.Collections.Immutable;
using Parallel.Base;
using Parallel.Vector;

namespace Parallel.Entity;

public class EntityCollection
{
    private List<Entity> _entities;

    public List<Entity> Entities => _entities;

    public static EntityCollection EmptyCollection
    {
        get => new EntityCollection();
    }

    public EntityCollection()
    {
        _entities = new List<Entity>();
    }


    public EntityCollection(List<Entity> entities)
    {
        _entities = entities;
    }

    //single APIs
    public int AddEntity(Entity? entity)
    {
        if (entity == null)
            return -1;
        _entities.Add(entity);
        return _entities.Count;
    }

    public int AddEntities(List<Entity>? entities)
    {
        if (entities == null)
            return -1;
        _entities.AddRange(entities);
        return _entities.Count;
    }

    public EntityCollection UnionOf(EntityCollection? other)
    {
        if (other == null)
            return this;
        List<Entity> list = _entities.Union(other._entities).ToList();
        return new EntityCollection(list);
    }

    public EntityCollection IntersectOf(EntityCollection? other)
    {
        if (other == null)
            return EntityCollection.EmptyCollection;
        List<Entity> list = _entities.Intersect(other._entities).ToList();
        return new EntityCollection(list);
    }

    public EntityCollection DifferenceOf(EntityCollection? other)
    {
        if (other == null)
            return this;
        List<Entity> list = _entities.Except(other._entities).ToList();
        return new EntityCollection(list);
    }

    public EntityCollection SymmetricDifferenceOf(EntityCollection? other)
    {
        if (other == null)
            return this;
        List<Entity> listUnion = _entities.Union(other._entities).ToList();
        List<Entity> listIntersect = _entities.Intersect(other._entities).ToList();
        List<Entity> list = listUnion.Except(listIntersect).ToList();
        return new EntityCollection(list);
    }

    public bool IsEntityExistById(int id)
    {
        bool exist = _entities.Exists(e => e.Id == id);
        return exist;
    }

    public Entity? FindEntityById(int id)
    {
        return _entities.Find(e => e.Id == id);
    }
    
    public int? FindIndexById(int id)
    {
        return _entities.FindIndex(e => e.Id == id);
    }

    public EntityCollection GetFriendlyOf(Entity? player)
    {
        if (player == null)
            return EntityCollection.EmptyCollection;
        EntityFaction fac = player.Faction;
        List<Entity> list = _entities.Where(e => e.Faction == fac).ToList();
        return new EntityCollection(list);
    }

    public EntityCollection GetEnemiesOf(Entity? player)
    {
        if (player == null)
            return EntityCollection.EmptyCollection;
        EntityFaction fac = Entity.GetOppositeFaction(player.Faction);
        List<Entity> list = _entities.Where(e => e.Faction == fac).ToList();
        return new EntityCollection(list);
    }

    public bool IsAllPlayer()
    {
        bool flag = _entities.All(e => e.Type == EntityType.Player);
        return flag;
    }
    
    public bool IsNonePlayer()
    {
        bool flag = !_entities.Any(e => e.Type == EntityType.Player);
        return flag;
    }
    
    public bool IsAllSummoned()
    {
        bool flag = _entities.All(e => e.Type == EntityType.Summoned);
        return flag;
    }
    
    public bool IsNoneSummoned()
    {
        bool flag = !_entities.Any(e => e.Type == EntityType.Summoned);
        return flag;
    }

    public int CountPlayersOfFaction(EntityFaction fac)
    {
        int num = _entities.Count(
            e => e.Type == EntityType.Player && e.Faction == fac);
        return num;
    }

    public int CountGroundObjectsOfFaction(EntityFaction fac)
    {
        int num = _entities.Count(
            e => e.Type == EntityType.GroundObject && e.Faction == fac);
        return num;
    }

    public EntityCollection SelectFromPlayers(int num)
    {
        if (!IsAllPlayer() || num <= 0)
            return EntityCollection.EmptyCollection;
        if (_entities.Count < num)
            return this;
        List<Entity> list = _entities.Take(num).ToList();
        return new EntityCollection(list);
    }

    public static EntityCollection NewSummons(int num)
    {
        List<Entity> list = Enumerable.Repeat(
            Entity.Create(EntityType.Summoned, EntityFaction.Neutral, new Vector3(0, 0, 0), 10),
            num).ToList();
        return new EntityCollection(list);
    }

    public static bool ClearAllSummons()
    {
        EntityCollection collection = Global.Instance.GlobalEntityCollection;
        int num = collection._entities.RemoveAll(e => e.Type == EntityType.Summoned);
        return num > 0;
    }

    public Dictionary<EntityType, EntityCollection> PartitionByType()
    {
        Dictionary<EntityType, List<Entity>> dict = _entities.GroupBy(i => i.Type)
            .ToDictionary(group => group.Key, group => group.ToList());
        Dictionary<EntityType, EntityCollection> collections = new Dictionary<EntityType, EntityCollection>();
        foreach (var entry in dict)
            collections[entry.Key] = new EntityCollection(entry.Value);
        return collections;
    }

    public Dictionary<EntityFaction, EntityCollection> PartitionByFaction()
    {
        Dictionary<EntityFaction, List<Entity>> dict = _entities.GroupBy(i => i.Faction)
            .ToDictionary(group => group.Key, group => group.ToList());
        Dictionary<EntityFaction, EntityCollection> collections = new Dictionary<EntityFaction, EntityCollection>();
        foreach (var entry in dict)
            collections[entry.Key] = new EntityCollection(entry.Value);
        return collections;
    }

    public Dictionary<bool, EntityCollection> PartitionByIsInjured()
    {
        Dictionary<bool, List<Entity>> dict = _entities.GroupBy(i => i.CurrentHealth == i.MaxHealth)
            .ToDictionary(group => group.Key, group => group.ToList());
        Dictionary<bool, EntityCollection> collections = new Dictionary<bool, EntityCollection>();
        foreach (var entry in dict)
            collections[entry.Key] = new EntityCollection(entry.Value);
        return collections;
    }

    public EntityCollection SortById()
    {
        List<Entity> list = _entities.OrderBy(e => e.Id).ToList();
        return new EntityCollection(list);
    }

    public EntityCollection SortByHealthPercent()
    {
        List<Entity> list = _entities.OrderBy(e => e.CurrentHealth / e.MaxHealth).ToList();
        return new EntityCollection(list);
    }

    public EntityCollection LeftRotateFromPlayers()
    {
        if (!IsAllPlayer())
            return EntityCollection.EmptyCollection;
        List<Entity> list = _entities.Skip(1).Concat(_entities.Take(1)).ToList();
        return new EntityCollection(list);
    }

    public EntityCollection RightRotateFromPlayers()
    {
        if (!IsAllPlayer())
            return EntityCollection.EmptyCollection;
        List<Entity> list = _entities.Skip(_entities.Count - 1).
            Concat(_entities.Take(_entities.Count - 1)).ToList();
        return new EntityCollection(list);
    }
    
    public EntityCollection ReverseFromPlayers()
    {
        if (!IsAllPlayer())
            return EntityCollection.EmptyCollection;
        List<Entity> list = new List<Entity>(_entities);
        list.Reverse();
        return new EntityCollection(list);
    }
    
    public Entity? FindLowestHealthEntity()
    {
        if (_entities.Count == 0) 
            return null;
        return _entities.MinBy(e => e.CurrentHealth);
    }
    
    public Entity? FindHighestHealthEntity()
    {
        if (_entities.Count == 0) 
            return null;
        return _entities.MaxBy(e => e.CurrentHealth);
    }
    
    public EntityCollection FindEntitiesWithinDistance(Entity entity, double dist)
    {
        Vector3 pos = entity.Pos;
        List<Entity> list = _entities.Where(e => pos.Distance(e.Pos) < dist).ToList();
        return new EntityCollection(list);
    }

    public bool ContainsEntity(Entity entity)
    {
        return _entities.Contains(entity);
    }
    
    public int DamageAllFromPlayers(double damageAmount)
    {
        if (!IsAllPlayer())
            return 0;
        _entities.ForEach(e => e.TakeDamage(damageAmount));
        return _entities.Count;
    }
    
    public EntityCollection ControlSummoned(EntityFaction fac)
    {
        if (!IsAllSummoned())
            return EntityCollection.EmptyCollection;
        _entities.ForEach(e => e.Faction = fac);
        return this;
    }

    public bool ChangePlayerFaction(Entity player)
    {
        List<Entity> players = _entities.Where(
            e => e.Type == EntityType.Player).ToList();
        if (players.Contains(player))
        {
            player.Faction = Entity.GetOppositeFaction(player.Faction);
            return true;
        }
        return false;
    }
    
    public bool ChangeSummonedFaction(Entity summoned)
    {
        List<Entity> summons = _entities.Where(
            e => e.Type == EntityType.Player).ToList();
        if (summons.Contains(summoned))
        {
            summoned.Faction = Entity.GetOppositeFaction(summoned.Faction);
            return true;
        }
        return false;
    }
    
    //multiple APIs
    
    public Entity? FindEntityWithinDistance(Entity entity, double dist)
    { 
        Vector3 pos = entity.Pos;
        return _entities.Find(e => pos.Distance(e.Pos) < dist);
    }
    
    public Entity? ReverseFindEntityWithinDistance(Entity entity, double dist)
    { 
        Vector3 pos = entity.Pos;
        return _entities.FindLast(e => pos.Distance(e.Pos) < dist);
    }
    
    public int FindIndexithinDistance(Entity entity, double dist)
    { 
        Vector3 pos = entity.Pos;
        return _entities.FindIndex(e => pos.Distance(e.Pos) < dist);
    }
    
    public int ReverseFindIndexWithinDistance(Entity entity, double dist)
    { 
        Vector3 pos = entity.Pos;
        return _entities.FindLastIndex(e => pos.Distance(e.Pos) < dist);
    }

    public bool IsAllPlayerFactionOf(EntityFaction faction)
    {
        List<Entity> players = _entities.Where(
            e => e.Type == EntityType.Player).ToList();
        bool flag = players.All(e => e.Faction == faction);
        return flag;
    }

    public bool IsNonePlayerFactionOf(EntityFaction faction)
    {
        List<Entity> players = _entities.Where(
            e => e.Type == EntityType.Player).ToList();
        bool flag = !players.Any(e => e.Faction == faction);
        return flag;
    }

    public EntityCollection SortedEntitiesWithinDistance(Entity entity, double dist)
    {
        Vector3 pos = entity.Pos;
        List<Entity> list = _entities.Where(e => pos.Distance(e.Pos) < dist)
            .OrderBy(e => pos.Distance(e.Pos)).ToList();
        return new EntityCollection(list);
    }

    public EntityCollection SortedEntitiesBeyondDistance(Entity entity, double dist)
    {
        Vector3 pos = entity.Pos;
        List<Entity> list = _entities.Where(e => pos.Distance(e.Pos) > dist)
            .OrderBy(e => pos.Distance(e.Pos)).ToList();
        return new EntityCollection(list);
    }

    public Entity? FindLastEntityWithinDistance(Entity entity, double dist)
    {
        Vector3 pos = entity.Pos;
        Entity? element = _entities.Where(e => pos.Distance(e.Pos) < dist)
            .MaxBy(e => pos.Distance(e.Pos));
        return element;
    }

    public Entity? FindFirstEntityBeyondDistance(Entity entity, double dist)
    {
        Vector3 pos = entity.Pos;
        Entity? element = _entities.Where(e => pos.Distance(e.Pos) > dist)
            .MinBy(e => pos.Distance(e.Pos));
        return element;
    }
    
    public Entity? FindLowestHealthEntityWithinDistance(Entity entity, double dist)
    {
        Vector3 pos = entity.Pos;
        Entity? element = _entities.Where(e => pos.Distance(e.Pos) < dist)
            .MinBy(e => e.CurrentHealth);
        return element;
    }
    
    public Entity? FindHighestHealthEntityWithinDistance(Entity entity, double dist)
    {
        Vector3 pos = entity.Pos;
        Entity? element = _entities.Where(e => pos.Distance(e.Pos) < dist)
            .MaxBy(e => e.CurrentHealth);
        return element;
    }

    public EntityCollection SelectRandomPlayers(int num)
    {
        List<Entity> players = _entities.Where(
            e => e.Type == EntityType.Player).ToList();
        if (players.Count == 0 || num <= 0)
            return EntityCollection.EmptyCollection;
        if (players.Count < num)
            return new EntityCollection(players);
        Random rng = new Random();
        List<Entity> selectedList = players.OrderBy(i => rng.Next()).Take(num).ToList();
        return new EntityCollection(selectedList);
    }

    public EntityCollection SelectRandomSummons(int num)
    {
        List<Entity> summons = _entities.Where(
            e => e.Type == EntityType.Summoned).ToList();
        if (summons.Count == 0 || num <= 0)
            return EntityCollection.EmptyCollection;
        if (summons.Count < num)
            return new EntityCollection(summons);
        Random rng = new Random();
        List<Entity> selectedList = summons.OrderBy(i => rng.Next()).Take(3).ToList();
        return new EntityCollection(selectedList);
    }
    
    public EntityCollection SelectAndLeftRotateSummons()
    {
        List<Entity> summons = _entities.Where(
            e => e.Type == EntityType.Summoned).ToList();
        List<Entity> list = summons.Skip(1).Concat(_entities.Take(1)).ToList();
        return new EntityCollection(list);
    }

    public EntityCollection SelectAndRightRotateSummons()
    {
        List<Entity> summons = _entities.Where(
            e => e.Type == EntityType.Summoned).ToList();
        List<Entity> list = summons.Skip(summons.Count - 1).
            Concat(summons.Take(summons.Count - 1)).ToList();
        return new EntityCollection(list);
    }
    
    public EntityCollection SelectAndReverseSummons()
    {
        List<Entity> summons = _entities.Where(
            e => e.Type == EntityType.Summoned).ToList();
        List<Entity> list = new List<Entity>(summons);
        list.Reverse();
        return new EntityCollection(list);
    }
    
    public EntityFaction FactionOfMoreEntities()
    {
        int numWarm = _entities.Count(e=>e.Faction == EntityFaction.WarmSide);
        int numCool = _entities.Count(e=>e.Faction == EntityFaction.CoolSide);
        if (numWarm > numCool)
            return EntityFaction.WarmSide;
        if (numCool > numWarm)
            return EntityFaction.CoolSide;
        return EntityFaction.Neutral;
    }
    
    public EntityFaction FactionOfMorePlayers()
    {
        List<Entity> players = _entities.Where(
            e => e.Type == EntityType.Player).ToList();
        int numWarm = players.Count(e=>e.Faction == EntityFaction.WarmSide);
        int numCool = players.Count(e=>e.Faction == EntityFaction.CoolSide);
        if (numWarm > numCool)
            return EntityFaction.WarmSide;
        if (numCool > numWarm)
            return EntityFaction.CoolSide;
        return EntityFaction.Neutral;
    }
    
    public EntityFaction FactionOfMorePlayersAndSummons()
    {
        List<Entity> playerAndSummons = _entities.Where(
            e => e.Type != EntityType.GroundObject).ToList();
        int numWarm = playerAndSummons.Count(e=>e.Faction == EntityFaction.WarmSide);
        int numCool = playerAndSummons.Count(e=>e.Faction == EntityFaction.CoolSide);
        if (numWarm > numCool)
            return EntityFaction.WarmSide;
        if (numCool > numWarm)
            return EntityFaction.CoolSide;
        return EntityFaction.Neutral;
    }
    
    public EntityCollection GetFriendlyPlayersOf(Entity? player)
    {
        if (player == null)
            return EntityCollection.EmptyCollection;
        EntityFaction fac = player.Faction;
        List<Entity> friendly = _entities.Where(e => e.Faction == fac ).ToList();
        List<Entity> list = friendly.Where(e => e.Type == EntityType.Player).ToList();
        return new EntityCollection(list);
    }
    
    public EntityCollection GetEnemyPlayersOf(Entity? player)
    {
        if (player == null)
            return EntityCollection.EmptyCollection;
        EntityFaction fac = Entity.GetOppositeFaction(player.Faction);
        List<Entity> friendly = _entities.Where(e => e.Faction == fac ).ToList();
        List<Entity> list = friendly.Where(e => e.Type == EntityType.Player).ToList();
        return new EntityCollection(list);
    }
    
    public EntityCollection SummonCopiesOfEnemySummoned(EntityFaction fac)
    {
        List<Entity> summons = _entities.Where(
            e => e.Type == EntityType.Summoned).ToList();
        List<Entity> facSummons = summons.Where(e => e.Faction == Entity.GetOppositeFaction(fac)).ToList();
        List<Entity> copies = facSummons.Select(e =>
            Entity.Create(EntityType.Summoned, fac, e.Pos, e.CurrentHealth)).ToList();
        return new EntityCollection(copies);
    }
    
    public EntityCollection SummonCopiesOfEnemyPlayerAsSummoned(EntityFaction fac)
    {
        List<Entity> players = _entities.Where(
            e => e.Type == EntityType.Player).ToList();
        List<Entity> enemyPlayers = players.Where(e => e.Faction == Entity.GetOppositeFaction(fac)).ToList();
        List<Entity> copies = enemyPlayers.Select(e =>
            Entity.Create(EntityType.Summoned, Entity.GetOppositeFaction(e.Faction), e.Pos, e.CurrentHealth)).ToList();
        return new EntityCollection(copies);
    }
    
    public Dictionary<EntityType, EntityCollection> PartitionFactionByType(EntityFaction fac)
    {
        List<Entity> entitiesOfFaction = _entities.Where(
            e => e.Faction == fac).ToList();
        Dictionary<EntityType, List<Entity>> dict = entitiesOfFaction.GroupBy(i => i.Type)
            .ToDictionary(group => group.Key, group => group.ToList());
        Dictionary<EntityType, EntityCollection> collections = new Dictionary<EntityType, EntityCollection>();
        foreach (var entry in dict)
            collections[entry.Key] = new EntityCollection(entry.Value);
        return collections;
    }

    public Dictionary<EntityFaction, EntityCollection> PartitionTypeByFaction(EntityType type)
    {
        List<Entity> entitiesOfType = _entities.Where(
            e => e.Type == type).ToList();
        Dictionary<EntityFaction, List<Entity>> dict = _entities.GroupBy(i => i.Faction)
            .ToDictionary(group => group.Key, group => group.ToList());
        Dictionary<EntityFaction, EntityCollection> collections = new Dictionary<EntityFaction, EntityCollection>();
        foreach (var entry in dict)
            collections[entry.Key] = new EntityCollection(entry.Value);
        return collections;
    }
    
    //Complex
    
    public int DamageAllEnemyPlayer(Entity? player, double damageAmount)
    {
        if (player == null)
            return 0;
        EntityFaction fac = Entity.GetOppositeFaction(player.Faction);
        List<Entity> players = _entities.Where(
            e => e.Type == EntityType.Player).ToList();
        List<Entity> enemyPlayers = players.Where(e => e.Faction == fac).ToList();
        enemyPlayers.ForEach(e => e.TakeDamage(damageAmount));
        return enemyPlayers.Count;
    }

    public EntityCollection ControlEnemySummonedWithinRange(Entity? player, double dist)
    {
        if (player == null)
            return EntityCollection.EmptyCollection;
        EntityFaction fac = Entity.GetOppositeFaction(player.Faction);
        Vector3 pos = player.Pos;
        List<Entity> list = _entities.Where(e => pos.Distance(e.Pos) < dist).ToList();
        List<Entity> summons = list.Where(
            e => e.Type == EntityType.Summoned).ToList();
        List<Entity> enemySummons = summons.Where(e => e.Faction == fac).ToList();
        enemySummons.ForEach(e => e.Faction = Entity.GetOppositeFaction(e.Faction));
        return new EntityCollection(enemySummons);
    }

    public EntityCollection SummonCopiesOfEnemySummonedWithinRange(Entity? player, double dist)
    {
        if (player == null)
            return EntityCollection.EmptyCollection;
        EntityFaction fac = Entity.GetOppositeFaction(player.Faction);
        Vector3 pos = player.Pos;
        List<Entity> list = _entities.Where(e => pos.Distance(e.Pos) < dist).ToList();
        List<Entity> summons = list.Where(
            e => e.Type == EntityType.Summoned).ToList();
        List<Entity> enemySummons = summons.Where(e => e.Faction == fac).ToList();
        List<Entity> copies = enemySummons.Select(e =>
            Entity.Create(e.Type, Entity.GetOppositeFaction(e.Faction), pos, e.CurrentHealth)).ToList();
        return new EntityCollection(copies);
    }
    
    public EntityCollection UnionOfPlayers(EntityCollection? other)
    {
        List<Entity> players = _entities.Where(
            e => e.Type == EntityType.Player).ToList();
        if (other == null)
            return new EntityCollection(players);
        List<Entity> otherPlayers = other._entities.Where(
            e => e.Type == EntityType.Player).ToList();
        if (otherPlayers.Count == 0)
            return new EntityCollection(players);
        List<Entity> list = players.Union(otherPlayers).ToList();
        return new EntityCollection(list);
    }

    public EntityCollection IntersectOfPlayers(EntityCollection? other)
    {
        List<Entity> players = _entities.Where(
            e => e.Type == EntityType.Player).ToList();
        if (other == null)
            return new EntityCollection(players);
        List<Entity> otherPlayers = other._entities.Where(
            e => e.Type == EntityType.Player).ToList();
        if (otherPlayers.Count == 0)
            return new EntityCollection(players);
        List<Entity> list = players.Intersect(otherPlayers).ToList();
        return new EntityCollection(list);
    }

    public EntityCollection DifferenceOfPlayers(EntityCollection? other)
    {
        List<Entity> players = _entities.Where(
            e => e.Type == EntityType.Player).ToList();
        if (other == null)
            return new EntityCollection(players);
        List<Entity> otherPlayers = other._entities.Where(
            e => e.Type == EntityType.Player).ToList();
        if (otherPlayers.Count == 0)
            return new EntityCollection(players);
        List<Entity> list = players.Except(otherPlayers).ToList();
        return new EntityCollection(list);
    }
    
    public Dictionary<EntityFaction, EntityCollection> ChangePlayerFactionAndPartitionPlayer(Entity player)
    {
        List<Entity> players = _entities.Where(
            e => e.Type == EntityType.Player).ToList();
        if (players.Contains(player))
            player.Faction = Entity.GetOppositeFaction(player.Faction);
        Dictionary<EntityFaction, List<Entity>> dict = players.GroupBy(i => i.Faction)
            .ToDictionary(group => group.Key, group => group.ToList());
        Dictionary<EntityFaction, EntityCollection> collections = new Dictionary<EntityFaction, EntityCollection>();
        foreach (var entry in dict)
            collections[entry.Key] = new EntityCollection(entry.Value);
        return collections;
    }
    
    public Dictionary<EntityFaction, EntityCollection> ChangeSummonedFactionAndPartitionPlayer(Entity summoned)
    {
        List<Entity> summons = _entities.Where(
            e => e.Type == EntityType.Summoned).ToList();
        if (summons.Contains(summoned))
            summoned.Faction = Entity.GetOppositeFaction(summoned.Faction);
        Dictionary<EntityFaction, List<Entity>> dict = summons.GroupBy(i => i.Faction)
            .ToDictionary(group => group.Key, group => group.ToList());
        Dictionary<EntityFaction, EntityCollection> collections = new Dictionary<EntityFaction, EntityCollection>();
        foreach (var entry in dict)
            collections[entry.Key] = new EntityCollection(entry.Value);
        return collections;
    }
    
    public Dictionary<EntityFaction, EntityCollection> ChangeGroundObjectFactionAndPartitionPlayer(Entity groundObject)
    {
        List<Entity> groundObjects = _entities.Where(
            e => e.Type == EntityType.GroundObject).ToList();
        if (groundObjects.Contains(groundObject))
            groundObject.Faction = Entity.GetOppositeFaction(groundObject.Faction);
        Dictionary<EntityFaction, List<Entity>> dict = groundObjects.GroupBy(i => i.Faction)
            .ToDictionary(group => group.Key, group => group.ToList());
        Dictionary<EntityFaction, EntityCollection> collections = new Dictionary<EntityFaction, EntityCollection>();
        foreach (var entry in dict)
            collections[entry.Key] = new EntityCollection(entry.Value);
        return collections;
    }
}