package parallel.entity;

import parallel.base.Global;
import parallel.vector.Vector3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EntityCollection {
    private List<Entity> entities;

    public List<Entity> getEntities() {
        return entities;
    }

    public static EntityCollection emptyCollection() {
        return new EntityCollection();
    }

    public EntityCollection() {
        entities = new ArrayList<Entity>();
    }

    public EntityCollection(List<Entity> entities) {
        this.entities = entities;
    }

    //single APIs
    public int addEntity(Entity entity) {
        if (entity == null)
            return -1;
        entities.add(entity);
        return entities.size();
    }

    public int addEntities(List<Entity> entities) {
        if (entities == null)
            return -1;
        entities.addAll(entities);
        return entities.size();
    }

    public EntityCollection UnionOf(EntityCollection other) {
        if (other == null)
            return this;
        Set<Entity> set = new HashSet<>(entities);
        set.addAll(other.entities);
        return new EntityCollection(set.stream().toList());
    }

    public EntityCollection IntersectOf(EntityCollection other) {
        if (other == null)
            return EntityCollection.emptyCollection();
        Set<Entity> set = new HashSet<>(entities);
        set.addAll(other.entities);
        return new EntityCollection(set.stream().toList());
    }

    public EntityCollection DifferenceOf(EntityCollection other) {
        if (other == null)
            return EntityCollection.emptyCollection();
        Set<Entity> set = new HashSet<>(entities);
        set.addAll(other.entities);
        return new EntityCollection(set.stream().toList());
    }

    public EntityCollection SymmetricDifferenceOf(EntityCollection other) {
        if (other == null)
            return this;
        Set<Entity> setUnion = new HashSet<>(entities);
        setUnion.addAll(other.entities);
        Set<Entity> setIntersect = new HashSet<>(entities);
        setIntersect.retainAll(other.entities);
        List<Entity> list = new ArrayList<>(setUnion);
        list.removeAll(setIntersect);
        return new EntityCollection(list);
    }

    public boolean isEntityExistById(int id) {
        boolean exist = entities.stream().anyMatch(e -> e.getId() == id);
        return exist;
    }

    public Optional<Entity> findEntityById(int id) {
        return entities.stream().filter(e -> e.getId() == id).findFirst();
    }

    public OptionalInt findIndexById(int id) {
        return IntStream.range(0, entities.size()).
                filter(i -> entities.get(i).getId() == id).findFirst();
    }

    public EntityCollection getFriendlyOf(Entity player) {
        if (player == null)
            return EntityCollection.emptyCollection();
        EntityFaction fac = player.getFaction();
        List<Entity> list = entities.stream().filter(e -> e.getFaction() == fac).collect(Collectors.toList());
        return new EntityCollection(list);
    }

    public EntityCollection getEnemiesOf(Entity player) {
        if (player == null)
            return EntityCollection.emptyCollection();
        EntityFaction fac = Entity.getOppositeFaction(player.getFaction());
        List<Entity> list = entities.stream().filter(e -> e.getFaction() == fac).collect(Collectors.toList());
        return new EntityCollection(list);
    }

    public boolean isAllPlayer() {
        boolean flag = entities.stream().allMatch(e -> e.getType() == EntityType.PLAYER);
        return flag;
    }

    public boolean isNonePlayer() {
        boolean flag = entities.stream().noneMatch(e -> e.getType() == EntityType.PLAYER);
        return flag;
    }

    public boolean isAllSummoned() {
        boolean flag = entities.stream().allMatch(e -> e.getType() == EntityType.SUMMONED);
        return flag;
    }

    public boolean isNoneSummoned() {
        boolean flag = entities.stream().noneMatch(e -> e.getType() == EntityType.SUMMONED);
        return flag;
    }

    public int countPlayersOfFaction(EntityFaction fac) {
        int num = (int) entities.stream().filter(
                e -> e.getType() == EntityType.PLAYER && e.getFaction() == fac).count();
        return num;
    }

    public int countGroundObjectsOfFaction(EntityFaction fac) {
        int num = (int) entities.stream().filter(
                e -> e.getType() == EntityType.GROUND_OBJECT && e.getFaction() == fac).count();
        return num;
    }

    public EntityCollection selectFromPlayers(int num) {
        if (!isAllPlayer() || num <= 0)
            return EntityCollection.emptyCollection();
        if (entities.size() < num)
            return this;
        List<Entity> list = entities.stream().limit(num).collect(Collectors.toList());
        return new EntityCollection(list);
    }

    public static EntityCollection newSummons(int num) {
        List<Entity> list = Collections.nCopies(num,
                Entity.create(EntityType.SUMMONED, EntityFaction.NEUTRAL, new Vector3(0, 0, 0), 10));
        return new EntityCollection(list);
    }

    public static boolean clearAllSummons() {
        EntityCollection collection = Global.getInstance().getGlobalEntityCollection();
        boolean bool = collection.entities.removeIf(e -> e.getType() == EntityType.SUMMONED);
        return bool;
    }

    public Map<EntityType, EntityCollection> partitionByType() {
        Map<EntityType, List<Entity>> dict = entities.stream().collect(Collectors.groupingBy(e -> e.getType()));
        Map<EntityType, EntityCollection> collections = new HashMap<EntityType, EntityCollection>();
        for (var entry : dict.entrySet())
            collections.put(entry.getKey(), new EntityCollection(entry.getValue()));
        return collections;
    }

    public Map<EntityFaction, EntityCollection> partitionByFaction() {
        Map<EntityFaction, List<Entity>> dict = entities.stream().collect(Collectors.groupingBy(e -> e.getFaction()));
        Map<EntityFaction, EntityCollection> collections = new HashMap<EntityFaction, EntityCollection>();
        for (var entry : dict.entrySet())
            collections.put(entry.getKey(), new EntityCollection(entry.getValue()));
        return collections;
    }

    public Map<Boolean, EntityCollection> PartitionByIsInjured() {
        Map<Boolean, List<Entity>> dict = entities.stream().collect(Collectors.
                groupingBy(e -> e.getCurrentHealth() == e.getMaxHealth()));
        Map<Boolean, EntityCollection> collections = new HashMap<Boolean, EntityCollection>();
        for (var entry : dict.entrySet())
            collections.put(entry.getKey(), new EntityCollection(entry.getValue()));
        return collections;
    }

    public EntityCollection sortById() {
        List<Entity> list = entities.stream().
                sorted(Comparator.comparing(e -> e.getId())).collect(Collectors.toList());
        return new EntityCollection(list);
    }

    public EntityCollection sortByHealthPercent() {
        List<Entity> list = entities.stream().
                sorted(Comparator.comparing(e -> e.getCurrentHealth() / e.getMaxHealth())).collect(Collectors.toList());
        return new EntityCollection(list);
    }

    public EntityCollection leftRotateFromPlayers() {
        if (!isAllPlayer())
            return EntityCollection.emptyCollection();
        List<Entity> list = new ArrayList<Entity>(entities);
        Collections.rotate(list, 1);
        return new EntityCollection(list);
    }

    public EntityCollection rightRotateFromPlayers() {
        if (!isAllPlayer())
            return EntityCollection.emptyCollection();
        List<Entity> list = new ArrayList<Entity>(entities);
        Collections.rotate(list, -1);
        return new EntityCollection(list);
    }

    public EntityCollection reverseFromPlayers() {
        if (!isAllPlayer())
            return EntityCollection.emptyCollection();
        List<Entity> list = new ArrayList<Entity>(entities);
        Collections.reverse(list);
        return new EntityCollection(list);
    }

    public Optional<Entity> findLowestHealthEntity() {
        if (entities.size() == 0)
            return Optional.empty();
        return entities.stream().min(Comparator.comparing(e -> e.getCurrentHealth()));
    }

    public Optional<Entity> findHighestHealthEntity() {
        if (entities.size() == 0)
            return Optional.empty();
        return entities.stream().max(Comparator.comparing(e -> e.getCurrentHealth()));
    }

    public EntityCollection findEntitiesWithinDistance(Entity entity, double dist) {
        Vector3 pos = entity.getPos();
        List<Entity> list = entities.stream().
                filter(e -> pos.distance(e.getPos()) < dist).collect(Collectors.toList());
        return new EntityCollection(list);
    }

    public boolean ContainsEntity(Entity entity) {
        return entities.contains(entity);
    }

    public int DamageAllFromPlayers(double damageAmount) {
        if (!isAllPlayer())
            return 0;
        entities.forEach(e -> e.takeDamage(damageAmount));
        return entities.size();
    }

    public EntityCollection controlSummoned(EntityFaction fac) {
        if (!isAllSummoned())
            return EntityCollection.emptyCollection();
        entities.forEach(e -> e.setFaction(fac));
        return this;
    }

    public boolean changePlayerFaction(Entity player) {
        List<Entity> players = entities.stream().filter(
                e -> e.getType() == EntityType.PLAYER).collect(Collectors.toList());
        if (players.contains(player)) {
            player.setFaction(Entity.getOppositeFaction(player.getFaction()));
            return true;
        }
        return false;
    }

    public boolean changeSummonedFaction(Entity summoned) {
        List<Entity> summons = entities.stream().filter(
                e -> e.getType() == EntityType.SUMMONED).collect(Collectors.toList());
        if (summons.contains(summoned)) {
            summoned.setFaction(Entity.getOppositeFaction(summoned.getFaction()));
            return true;
        }
        return false;
    }

    //multiple APIs

    public Optional<Entity> findEntityWithinDistance(Entity entity, double dist) {
        Vector3 pos = entity.getPos();
        return entities.stream().filter(e -> pos.distance(entity.getPos()) < dist).findFirst();
    }

    public Optional<Entity> reverseFindEntityWithinDistance(Entity entity, double dist) {
        Vector3 pos = entity.getPos();
        return entities.stream().filter(e -> pos.distance(entity.getPos()) < dist).reduce((first, second) -> second);
    }

    public int findIndexithinDistance(Entity entity, double dist) {
        Vector3 pos = entity.getPos();
        return IntStream.range(0, entities.size()).filter(i ->
                pos.distance(entities.get(i).getPos()) < dist).findFirst().orElse(-1);
    }

    public int reverseFindIndexWithinDistance(Entity entity, double dist) {
        Vector3 pos = entity.getPos();
        return IntStream.range(0, entities.size()).filter(i ->
                        pos.distance(entities.get(i).getPos()) < dist).
                reduce((first, second) -> second).orElse(-1);
    }

    public boolean isAllPlayerFactionOf(EntityFaction faction) {
        List<Entity> players = entities.stream().filter(
                e -> e.getType() == EntityType.PLAYER).collect(Collectors.toList());
        boolean flag = players.stream().allMatch(e -> e.getFaction() == faction);
        return flag;
    }

    public boolean isNonePlayerFactionOf(EntityFaction faction) {
        List<Entity> players = entities.stream().filter(
                e -> e.getType() == EntityType.PLAYER).collect(Collectors.toList());
        boolean flag = players.stream().noneMatch(e -> e.getFaction() == faction);
        return flag;
    }

    public EntityCollection sortedEntitiesWithinDistance(Entity entity, double dist) {
        Vector3 pos = entity.getPos();
        List<Entity> list = entities.stream().filter(e -> pos.distance(e.getPos()) < dist)
                .sorted(Comparator.comparing(e -> pos.distance(e.getPos()))).collect(Collectors.toList());
        return new EntityCollection(list);
    }

    public EntityCollection sortedEntitiesBeyondDistance(Entity entity, double dist) {
        Vector3 pos = entity.getPos();
        List<Entity> list = entities.stream().filter(e -> pos.distance(e.getPos()) > dist)
                .sorted(Comparator.comparing(e -> pos.distance(e.getPos()))).collect(Collectors.toList());
        return new EntityCollection(list);
    }

    public Optional<Entity> findLastEntityWithinDistance(Entity entity, double dist) {
        Vector3 pos = entity.getPos();
        Optional<Entity> element = entities.stream().filter(e -> pos.distance(e.getPos()) < dist)
                .max(Comparator.comparing(e -> pos.distance(e.getPos())));
        return element;
    }

    public Optional<Entity> FindFirstEntityBeyondDistance(Entity entity, double dist) {
        Vector3 pos = entity.getPos();
        Optional<Entity> element = entities.stream().filter(e -> pos.distance(e.getPos()) > dist)
                .min(Comparator.comparing(e -> pos.distance(e.getPos())));
        return element;
    }

    public Optional<Entity> findLowestHealthEntityWithinDistance(Entity entity, double dist) {
        Vector3 pos = entity.getPos();
        Optional<Entity> element = entities.stream().filter(e -> pos.distance(e.getPos()) < dist)
                .min(Comparator.comparing(e -> e.getCurrentHealth()));
        return element;
    }

    public Optional<Entity> findHighestHealthEntityWithinDistance(Entity entity, double dist) {
        Vector3 pos = entity.getPos();
        Optional<Entity> element = entities.stream().filter(e -> pos.distance(e.getPos()) < dist)
                .max(Comparator.comparing(e -> e.getCurrentHealth()));
        return element;
    }

    public EntityCollection selectRandomPlayers(int num) {
        List<Entity> players = entities.stream().filter(
                e -> e.getType() == EntityType.PLAYER).collect(Collectors.toList());
        if (players.size() == 0 || num <= 0)
            return EntityCollection.emptyCollection();
        if (players.size() < num)
            return new EntityCollection(players);
        Random rng = new Random();
        List<Entity> selectedList = players.stream().sorted(Comparator.comparing(i -> rng.nextDouble())).
                limit(num).collect(Collectors.toList());
        return new EntityCollection(selectedList);
    }

    public EntityCollection selectRandomSummons(int num) {
        List<Entity> summons = entities.stream().filter(
                e -> e.getType() == EntityType.SUMMONED).collect(Collectors.toList());
        if (summons.size() == 0 || num <= 0)
            return EntityCollection.emptyCollection();
        if (summons.size() < num)
            return new EntityCollection(summons);
        Random rng = new Random();
        List<Entity> selectedList = summons.stream().sorted(Comparator.comparing(i -> rng.nextDouble())).
                limit(num).collect(Collectors.toList());
        return new EntityCollection(selectedList);
    }

    public EntityCollection selectAndLeftRotateSummons() {
        List<Entity> summons = entities.stream().filter(
                e -> e.getType() == EntityType.SUMMONED).collect(Collectors.toList());
        Collections.rotate(summons, 1);
        return new EntityCollection(summons);
    }

    public EntityCollection selectAndRightRotateSummons() {
        List<Entity> summons = entities.stream().filter(
                e -> e.getType() == EntityType.SUMMONED).collect(Collectors.toList());
        Collections.rotate(summons, -1);
        return new EntityCollection(summons);
    }

    public EntityCollection selectAndReverseSummons() {
        List<Entity> summons = entities.stream().filter(
                e -> e.getType() == EntityType.SUMMONED).collect(Collectors.toList());
        Collections.reverse(summons);
        return new EntityCollection(summons);
    }

    public EntityFaction factionOfMoreEntities() {
        int numWarm = (int) entities.stream().filter(e -> e.getFaction() == EntityFaction.WARM_SIDE).count();
        int numCool = (int) entities.stream().filter(e -> e.getFaction() == EntityFaction.COOL_SIDE).count();
        if (numWarm > numCool)
            return EntityFaction.WARM_SIDE;
        if (numCool > numWarm)
            return EntityFaction.COOL_SIDE;
        return EntityFaction.NEUTRAL;
    }

    public EntityFaction factionOfMorePlayers() {
        List<Entity> players = entities.stream().filter(e -> e.getType() == EntityType.PLAYER).collect(Collectors.toList());
        int numWarm = (int) entities.stream().filter(e -> e.getFaction() == EntityFaction.WARM_SIDE).count();
        int numCool = (int) entities.stream().filter(e -> e.getFaction() == EntityFaction.COOL_SIDE).count();
        if (numWarm > numCool)
            return EntityFaction.WARM_SIDE;
        if (numCool > numWarm)
            return EntityFaction.COOL_SIDE;
        return EntityFaction.NEUTRAL;
    }

    public EntityFaction factionOfMorePlayersAndSummons() {
        List<Entity> players = entities.stream().filter(e -> e.getType() != EntityType.GROUND_OBJECT).collect(Collectors.toList());
        int numWarm = (int) entities.stream().filter(e -> e.getFaction() == EntityFaction.WARM_SIDE).count();
        int numCool = (int) entities.stream().filter(e -> e.getFaction() == EntityFaction.COOL_SIDE).count();
        if (numWarm > numCool)
            return EntityFaction.WARM_SIDE;
        if (numCool > numWarm)
            return EntityFaction.COOL_SIDE;
        return EntityFaction.NEUTRAL;
    }

    public EntityCollection getFriendlyPlayersOf(Entity player) {
        if (player == null)
            return EntityCollection.emptyCollection();
        EntityFaction fac = player.getFaction();
        List<Entity> friendly = entities.stream().filter(e -> e.getFaction() == fac).collect(Collectors.toList());
        List<Entity> list = friendly.stream().filter(e -> e.getType() == EntityType.PLAYER).collect(Collectors.toList());
        return new EntityCollection(list);
    }

    public EntityCollection GetEnemyPlayersOf(Entity player) {
        if (player == null)
            return EntityCollection.emptyCollection();
        EntityFaction fac = Entity.getOppositeFaction(player.getFaction());
        List<Entity> friendly = entities.stream().filter(e -> e.getFaction() == fac).collect(Collectors.toList());
        List<Entity> list = friendly.stream().filter(e -> e.getType() == EntityType.PLAYER).collect(Collectors.toList());
        return new EntityCollection(list);
    }

    public EntityCollection summonCopiesOfEnemySummoned(EntityFaction fac) {
        List<Entity> summons = entities.stream().filter(
                e -> e.getType() == EntityType.SUMMONED).collect(Collectors.toList());
        List<Entity> facSummons = summons.stream().filter(
                e -> e.getFaction() == Entity.getOppositeFaction(fac)).collect(Collectors.toList());
        List<Entity> copies = facSummons.stream().map(e ->
                        Entity.create(EntityType.SUMMONED, fac, e.getPos(), e.getCurrentHealth()))
                .collect(Collectors.toList());
        return new EntityCollection(copies);
    }

    public EntityCollection summonCopiesOfEnemyPlayerAsSummoned(EntityFaction fac) {
        List<Entity> players = entities.stream().filter(
                e -> e.getType() == EntityType.PLAYER).collect(Collectors.toList());
        List<Entity> enemyPlayers = players.stream().
                filter(e -> e.getFaction() == Entity.getOppositeFaction(fac)).collect(Collectors.toList());
        List<Entity> copies = enemyPlayers.stream().map(e ->
                Entity.create(EntityType.SUMMONED, Entity.getOppositeFaction(e.getFaction()),
                        e.getPos(), e.getCurrentHealth())).collect(Collectors.toList());
        return new EntityCollection(copies);
    }

    public Map<EntityType, EntityCollection> partitionFactionByType(EntityFaction fac) {
        List<Entity> entitiesOfFaction = entities.stream().filter(
                e -> e.getFaction() == fac).collect(Collectors.toList());
        Map<EntityType, List<Entity>> dict = entitiesOfFaction.stream().collect(
                Collectors.groupingBy(i -> i.getType()));
        Map<EntityType, EntityCollection> collections = new HashMap<EntityType, EntityCollection>();
        for (var entry : dict.entrySet())
            collections.put(entry.getKey(), new EntityCollection(entry.getValue()));
        return collections;
    }

    public Map<EntityFaction, EntityCollection> partitionTypeByFaction(EntityType type) {
        List<Entity> entitiesOfType = entities.stream().filter(
                e -> e.getType() == type).collect(Collectors.toList());
        Map<EntityFaction, List<Entity>> dict = entities.stream().collect(Collectors.groupingBy(i -> i.getFaction()));
        Map<EntityFaction, EntityCollection> collections = new HashMap<EntityFaction, EntityCollection>();
        for (var entry : dict.entrySet())
            collections.put(entry.getKey(), new EntityCollection(entry.getValue()));
        return collections;
    }

//Complex

    public int damageAllEnemyPlayer(Entity player, double damageAmount) {
        if (player == null)
            return 0;
        EntityFaction fac = Entity.getOppositeFaction(player.getFaction());
        List<Entity> players = entities.stream().filter(
                e -> e.getType() == EntityType.PLAYER).collect(Collectors.toList());
        List<Entity> enemyPlayers = players.stream().filter(e -> e.getFaction() == fac).collect(Collectors.toList());
        enemyPlayers.forEach(e -> e.takeDamage(damageAmount));
        return enemyPlayers.size();
    }

    public EntityCollection controlEnemySummonedWithinRange(Entity player, double dist) {
        if (player == null)
            return EntityCollection.emptyCollection();
        EntityFaction fac = Entity.getOppositeFaction(player.getFaction());
        Vector3 pos = player.getPos();
        List<Entity> list = entities.stream().filter(e -> pos.distance(e.getPos()) < dist)
                .collect(Collectors.toList());
        List<Entity> summons = list.stream().filter(
                e -> e.getType() == EntityType.SUMMONED).collect(Collectors.toList());
        List<Entity> enemySummons = summons.stream().filter(e -> e.getFaction() == fac)
                .collect(Collectors.toList());
        enemySummons.forEach(e -> e.setFaction(Entity.getOppositeFaction(e.getFaction())));
        return new EntityCollection(enemySummons);
    }

    public EntityCollection summonCopiesOfEnemySummonedWithinRange(Entity player, double dist) {
        if (player == null)
            return EntityCollection.emptyCollection();
        EntityFaction fac = Entity.getOppositeFaction(player.getFaction());
        Vector3 pos = player.getPos();
        List<Entity> list = entities.stream().filter(e -> pos.distance(e.getPos()) < dist)
                .collect(Collectors.toList());
        List<Entity> summons = list.stream().filter(
                e -> e.getType() == EntityType.SUMMONED).collect(Collectors.toList());
        List<Entity> enemySummons = summons.stream().filter(e -> e.getFaction() == fac)
                .collect(Collectors.toList());
        List<Entity> copies = enemySummons.stream().map(e ->
                        Entity.create(e.getType(), Entity.getOppositeFaction(e.getFaction()), pos, e.getCurrentHealth()))
                .collect(Collectors.toList());
        return new EntityCollection(copies);
    }

    public EntityCollection unionOfPlayers(EntityCollection other) {
        Set<Entity> players = entities.stream().filter(
                e -> e.getType() == EntityType.PLAYER).collect(Collectors.toSet());
        if (other == null)
            return new EntityCollection(players.stream().toList());
        Set<Entity> otherPlayers = other.entities.stream().filter(
                e -> e.getType() == EntityType.PLAYER).collect(Collectors.toSet());
        if (otherPlayers.size() == 0)
            return new EntityCollection(players.stream().toList());
        Set<Entity> set = new HashSet<>(players);
        set.addAll(otherPlayers);
        return new EntityCollection(set.stream().toList());
    }

    public EntityCollection intersectOfPlayers(EntityCollection other) {
        Set<Entity> players = entities.stream().filter(
                e -> e.getType() == EntityType.PLAYER).collect(Collectors.toSet());
        if (other == null)
            return new EntityCollection(players.stream().toList());
        Set<Entity> otherPlayers = other.entities.stream().filter(
                e -> e.getType() == EntityType.PLAYER).collect(Collectors.toSet());
        if (otherPlayers.size() == 0)
            return new EntityCollection(players.stream().toList());
        Set<Entity> set = new HashSet<>(players);
        set.retainAll(otherPlayers);
        return new EntityCollection(set.stream().toList());
    }

    public EntityCollection differenceOfPlayers(EntityCollection other) {
        Set<Entity> players = entities.stream().filter(
                e -> e.getType() == EntityType.PLAYER).collect(Collectors.toSet());
        if (other == null)
            return new EntityCollection(players.stream().toList());
        Set<Entity> otherPlayers = other.entities.stream().filter(
                e -> e.getType() == EntityType.PLAYER).collect(Collectors.toSet());
        if (otherPlayers.size() == 0)
            return new EntityCollection(players.stream().toList());
        Set<Entity> set = new HashSet<>(players);
        set.removeAll(otherPlayers);
        return new EntityCollection(set.stream().toList());
    }

    public Map<EntityFaction, EntityCollection> ChangePlayerFactionAndPartitionPlayer(Entity player) {
        List<Entity> players = entities.stream().filter(
                e -> e.getType() == EntityType.PLAYER).collect(Collectors.toList());
        if (players.contains(player))
            player.setFaction(Entity.getOppositeFaction(player.getFaction()));
        Map<EntityFaction, List<Entity>> dict = players.stream().
                collect(Collectors.groupingBy(i -> i.getFaction()));
        Map<EntityFaction, EntityCollection> collections = new HashMap<EntityFaction, EntityCollection>();
        for (var entry : dict.entrySet())
            collections.put(entry.getKey(), new EntityCollection(entry.getValue()));
        return collections;
    }

    public Map<EntityFaction, EntityCollection> changeSummonedFactionAndPartitionPlayer(Entity summoned) {
        List<Entity> players = entities.stream().filter(
                e -> e.getType() == EntityType.SUMMONED).collect(Collectors.toList());
        if (players.contains(summoned))
            summoned.setFaction(Entity.getOppositeFaction(summoned.getFaction()));
        Map<EntityFaction, List<Entity>> dict = players.stream().
                collect(Collectors.groupingBy(i -> i.getFaction()));
        Map<EntityFaction, EntityCollection> collections = new HashMap<EntityFaction, EntityCollection>();
        for (var entry : dict.entrySet())
            collections.put(entry.getKey(), new EntityCollection(entry.getValue()));
        return collections;
    }

    public Map<EntityFaction, EntityCollection> ChangeGroundObjectFactionAndPartitionPlayer(Entity groundObject) {
        List<Entity> players = entities.stream().filter(
                e -> e.getType() == EntityType.GROUND_OBJECT).collect(Collectors.toList());
        if (players.contains(groundObject))
            groundObject.setFaction(Entity.getOppositeFaction(groundObject.getFaction()));
        Map<EntityFaction, List<Entity>> dict = players.stream().
                collect(Collectors.groupingBy(i -> i.getFaction()));
        Map<EntityFaction, EntityCollection> collections = new HashMap<EntityFaction, EntityCollection>();
        for (var entry : dict.entrySet())
            collections.put(entry.getKey(), new EntityCollection(entry.getValue()));
        return collections;
    }
}
