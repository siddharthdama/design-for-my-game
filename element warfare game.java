import java.util.*;

// ==========================================
// 1. CORE ENUMS & DEFINITIONS
// ==========================================
enum Element {
    FIRE, WATER, EARTH, AIR, NONE
}

enum StatusEffect {
    BURNING, WET, BRITTLE_EARTH, CHARGED_AIR, FROZEN
}

// ==========================================
// 2. SKILL DATA STRUCTURE
// ==========================================
class ElementalSkill {
    private final int levelRequired;
    private final String name;
    private final double baseDamage;
    private final double manaCost;
    private final StatusEffect statusApplied;
    private final String description;

    public ElementalSkill(int levelRequired, String name, double baseDamage, double manaCost, 
                          StatusEffect statusApplied, String description) {
        this.levelRequired = levelRequired;
        this.name = name;
        this.baseDamage = baseDamage;
        this.manaCost = manaCost;
        this.statusApplied = statusApplied;
        this.description = description;
    }

    public int getLevelRequired() { return levelRequired; }
    public String getName() { return name; }
    public double getBaseDamage() { return baseDamage; }
    public double getManaCost() { return manaCost; }
    public StatusEffect getStatusApplied() { return statusApplied; }
    public String getDescription() { return description; }
}

// ==========================================
// 3. PROGRESSION REPOSITORY (10 LEVELS EACH)
// ==========================================
class SkillRepository {
    private static final Map<Element, List<ElementalSkill>> SKILLS_BY_ELEMENT = new EnumMap<>(Element.class);

    static {
        for (Element e : Element.values()) {
            SKILLS_BY_ELEMENT.put(e, new ArrayList<>());
        }
        populateFireSkills();
        populateWaterSkills();
        populateEarthSkills();
        populateAirSkills();
    }

    private static void populateFireSkills() {
        List<ElementalSkill> fire = SKILLS_BY_ELEMENT.get(Element.FIRE);
        fire.add(new ElementalSkill(1, "Ember Strike", 25.0, 10.0, StatusEffect.BURNING, "Infuses melee blows with spark."));
        fire.add(new ElementalSkill(2, "Thermal Dash", 40.0, 18.0, StatusEffect.BURNING, "Propulsion slide igniting ground in your wake."));
        fire.add(new ElementalSkill(3, "Combustion Arc", 65.0, 25.0, StatusEffect.BURNING, "Cleave attack detonating ambient heat."));
        fire.add(new ElementalSkill(4, "Cauterize Armor", 85.0, 35.0, StatusEffect.BURNING, "Thermal lance searing defensive plating."));
        fire.add(new ElementalSkill(5, "Blazing Torrent", 120.0, 48.0, StatusEffect.BURNING, "Continuous stream of pressurized napalm flame."));
        fire.add(new ElementalSkill(6, "Molten Eruption", 160.0, 60.0, StatusEffect.BURNING, "Ruptures the floor with geysers of liquid fire."));
        fire.add(new ElementalSkill(7, "Ignis Vortex", 210.0, 75.0, StatusEffect.BURNING, "Centripetal fire funnel pulling foes inward."));
        fire.add(new ElementalSkill(8, "Supernova Pulse", 270.0, 90.0, StatusEffect.BURNING, "Radial shockwave melting incoming kinetic strikes."));
        fire.add(new ElementalSkill(9, "Inferno Cataclysm", 340.0, 110.0, StatusEffect.BURNING, "Rains orbital meteoric fire on the zone."));
        fire.add(new ElementalSkill(10, "Avatar of the Sun", 450.0, 140.0, StatusEffect.BURNING, "Transcends flesh into living thermonuclear plasma."));
    }

    private static void populateWaterSkills() {
        List<ElementalSkill> water = SKILLS_BY_ELEMENT.get(Element.WATER);
        water.add(new ElementalSkill(1, "Tide Whip", 20.0, 8.0, StatusEffect.WET, "High-velocity liquid lash slicing through defenses."));
        water.add(new ElementalSkill(2, "Aqua Barrier", 35.0, 15.0, StatusEffect.WET, "Fluid shield absorbing shock and wetting close threats."));
        water.add(new ElementalSkill(3, "Frost Needle", 60.0, 24.0, StatusEffect.FROZEN, "Flash-freezes targeted moisture into piercing icicles."));
        water.add(new ElementalSkill(4, "Riptide Surge", 80.0, 32.0, StatusEffect.WET, "Sweeps opposing vanguards backward with wave force."));
        water.add(new ElementalSkill(5, "Glacial Spire", 115.0, 45.0, StatusEffect.FROZEN, "Summons dense ice column impaling airborne enemies."));
        water.add(new ElementalSkill(6, "Mist Veil", 145.0, 55.0, StatusEffect.WET, "Saturates air with dense steam, granting stealth."));
        water.add(new ElementalSkill(7, "Abyssal Geyser", 195.0, 70.0, StatusEffect.WET, "High-pressure thermal water column from below."));
        water.add(new ElementalSkill(8, "Permafrost Tomb", 250.0, 85.0, StatusEffect.FROZEN, "Deep freezes organic targets down to core cells."));
        water.add(new ElementalSkill(9, "Tsunami Vanguard", 320.0, 105.0, StatusEffect.WET, "Summons a tidal crest washing over fortifications."));
        water.add(new ElementalSkill(10, "Oceanic Leviathan", 420.0, 135.0, StatusEffect.WET, "Commands continental currents to drown whole regiments."));
    }

    private static void populateEarthSkills() {
        List<ElementalSkill> earth = SKILLS_BY_ELEMENT.get(Element.EARTH);
        earth.add(new ElementalSkill(1, "Rock Throw", 28.0, 12.0, StatusEffect.BRITTLE_EARTH, "Launches rough slate boulder breaking stance."));
        earth.add(new ElementalSkill(2, "Stone Bastion", 42.0, 20.0, StatusEffect.BRITTLE_EARTH, "Rises heavy lithic wall deflecting linear shots."));
        earth.add(new ElementalSkill(3, "Tremor Stomp", 68.0, 28.0, StatusEffect.BRITTLE_EARTH, "Ground pound destabilizing enemy balance."));
        earth.add(new ElementalSkill(4, "Crystalline Spikes", 90.0, 38.0, StatusEffect.BRITTLE_EARTH, "Quartz spikes eruption piercing boots and treads."));
        earth.add(new ElementalSkill(5, "Seismic Charge", 125.0, 50.0, StatusEffect.BRITTLE_EARTH, "Compresses soil to launch a targeted subsurface quake."));
        earth.add(new ElementalSkill(6, "Granite Carapace", 165.0, 62.0, StatusEffect.BRITTLE_EARTH, "Hardens user's flesh into living diamond matrix."));
        earth.add(new ElementalSkill(7, "Chasm Splitter", 220.0, 78.0, StatusEffect.BRITTLE_EARTH, "Cracks open tectonic trench swallowing frontlines."));
        earth.add(new ElementalSkill(8, "Monolith Slam", 280.0, 95.0, StatusEffect.BRITTLE_EARTH, "Extracts a basalt column and smashes it overhead."));
        earth.add(new ElementalSkill(9, "Tectonic Cataclysm", 350.0, 115.0, StatusEffect.BRITTLE_EARTH, "Inverts local plate tectonics to shatter bastions."));
        earth.add(new ElementalSkill(10, "Primordial Pangea", 460.0, 145.0, StatusEffect.BRITTLE_EARTH, "Reshapes continental geography around the caster."));
    }

    private static void populateAirSkills() {
        List<ElementalSkill> air = SKILLS_BY_ELEMENT.get(Element.AIR);
        air.add(new ElementalSkill(1, "Gust Shard", 22.0, 9.0, StatusEffect.CHARGED_AIR, "Cuts forward with vacuum blades at high velocity."));
        air.add(new ElementalSkill(2, "Updraft Leap", 36.0, 16.0, StatusEffect.CHARGED_AIR, "Launches player into aerial vantage point."));
        air.add(new ElementalSkill(3, "Vacuum Pull", 62.0, 26.0, StatusEffect.CHARGED_AIR, "Implodes air pocket to yank snipers off ledges."));
        air.add(new ElementalSkill(4, "Gale Deflection", 82.0, 34.0, StatusEffect.CHARGED_AIR, "High-RPM wind shield bouncing back kinetic shells."));
        air.add(new ElementalSkill(5, "Sonic Blast", 118.0, 46.0, StatusEffect.CHARGED_AIR, "Shockwave rupturing sound barrier, concussing ranks."));
        air.add(new ElementalSkill(6, "Eye of Cyclone", 155.0, 58.0, StatusEffect.CHARGED_AIR, "Anchors safe center while external vortex rips terrain."));
        air.add(new ElementalSkill(7, "Thunderhead Lance", 205.0, 72.0, StatusEffect.CHARGED_AIR, "Pressurizes ozone into piercing ionized bolt."));
        air.add(new ElementalSkill(8, "Atmospheric Crush", 260.0, 88.0, StatusEffect.CHARGED_AIR, "Drops ambient barometric pressure, suffocating targets."));
        air.add(new ElementalSkill(9, "Tempest Sovereign", 330.0, 108.0, StatusEffect.CHARGED_AIR, "Summons localized hurricane disrupting an entire hex."));
        air.add(new ElementalSkill(10, "Void Horizon", 440.0, 138.0, StatusEffect.CHARGED_AIR, "Removes all gas molecules locally, creating total vacuum."));
    }

    public static ElementalSkill getSkillByLevel(Element element, int level) {
        if (level < 1 || level > 10) return null;
        return SKILLS_BY_ELEMENT.get(element).get(level - 1);
    }

    public static List<ElementalSkill> getAllUnlockedSkills(Element element, int currentLevel) {
        List<ElementalSkill> unlocked = new ArrayList<>();
        List<ElementalSkill> all = SKILLS_BY_ELEMENT.get(element);
        for (int i = 0; i < Math.min(currentLevel, 10); i++) {
            unlocked.add(all.get(i));
        }
        return Collections.unmodifiableList(unlocked);
    }
}

// ==========================================
// 4. COMBATANT & REACTION ENGINE
// ==========================================
class Combatant {
    private final String name;
    private final Element nation;
    private int level;
    private double health;
    private double maxHealth;
    private double mana;
    private double maxMana;
    private final Set<StatusEffect> activeStatuses;

    public Combatant(String name, Element nation, int level, double health, double mana) {
        this.name = name;
        this.nation = nation;
        this.level = Math.min(Math.max(level, 1), 10);
        this.health = health;
        this.maxHealth = health;
        this.mana = mana;
        this.maxMana = mana;
        this.activeStatuses = new HashSet<>();
    }

    public void castSkill(int skillTier, Combatant target) {
        ElementalSkill skill = SkillRepository.getSkillByLevel(this.nation, skillTier);
        if (skill == null) {
            System.out.printf("[%s] Invalid skill tier %d!%n", this.name, skillTier);
            return;
        }

        if (this.level < skill.getLevelRequired()) {
            System.out.printf("[%s] Level too low! Requires Level %d (Current: %d)%n", 
                              this.name, skill.getLevelRequired(), this.level);
            return;
        }

        if (this.mana < skill.getManaCost()) {
            System.out.printf("[%s] Insufficient mana to cast %s! (Needs %.1f, Has %.1f)%n", 
                              this.name, skill.getName(), skill.getManaCost(), this.mana);
            return;
        }

        this.mana -= skill.getManaCost();
        System.out.printf("[%s] casts Tier %d [%s] on [%s]!%n", this.name, skillTier, skill.getName(), target.getName());
        target.receiveElementalDamage(skill.getBaseDamage(), skill.getStatusApplied(), this.nation);
    }

    public void receiveElementalDamage(double rawDamage, StatusEffect incomingStatus, Element attackerElement) {
        double multiplier = 1.0;
        String reactionMsg = "";

        // Check cross-element reactions against active status effects
        if (activeStatuses.contains(StatusEffect.WET) && incomingStatus == StatusEffect.CHARGED_AIR) {
            multiplier = 2.0;
            reactionMsg = ">> REACTION: CONDUCTION! Arc lightning chains for double damage!";
        } else if (activeStatuses.contains(StatusEffect.BRITTLE_EARTH) && incomingStatus == StatusEffect.BURNING) {
            multiplier = 1.75;
            reactionMsg = ">> REACTION: MAGMA BLOOM! Stone liquifies, bypassing heavy defense!";
        } else if (activeStatuses.contains(StatusEffect.FROZEN) && incomingStatus == StatusEffect.BURNING) {
            multiplier = 2.2;
            reactionMsg = ">> REACTION: THERMAL SHOCK! Ice shatters with catastrophic blast!";
            activeStatuses.remove(StatusEffect.FROZEN);
        } else if (activeStatuses.contains(StatusEffect.BURNING) && incomingStatus == StatusEffect.WET) {
            multiplier = 1.25;
            reactionMsg = ">> REACTION: VAPORIZE! Steam cloud erupts, reducing target visibility!";
            activeStatuses.remove(StatusEffect.BURNING);
        }

        double finalDamage = rawDamage * multiplier;
        this.health = Math.max(0, this.health - finalDamage);
        activeStatuses.add(incomingStatus);

        if (!reactionMsg.isEmpty()) {
            System.out.println(reactionMsg);
        }

        System.out.printf("   --> Target [%s] takes %.1f damage! Remaining HP: %.1f/%.1f | Status: %s%n",
                this.name, finalDamage, this.health, this.maxHealth, activeStatuses);
    }

    public void printSkillBook() {
        System.out.println("==================================================");
        System.out.printf("  SKILL GRIMOIRE: %s (Nation: %s | Level %d)%n", name, nation, level);
        System.out.println("==================================================");
        List<ElementalSkill> skills = SkillRepository.getAllUnlockedSkills(nation, level);
        for (ElementalSkill s : skills) {
            System.out.printf("  [Lvl %2d] %-20s | Dmg: %5.1f | Mana: %4.1f | Proc: %-13s%n",
                    s.getLevelRequired(), s.getName(), s.getBaseDamage(), s.getManaCost(), s.getStatusApplied());
            System.out.printf("           Note: %s%n", s.getDescription());
        }
        System.out.println("==================================================\n");
    }

    public String getName() { return name; }
    public double getHealth() { return health; }
}

// ==========================================
// 5. MAIN SIMULATION / VERIFICATION
// ==========================================
public class ElementalWarfareEngine {
    public static void main(String[] args) {
        // Instantiate combatants across nations with distinct tiers
        Combatant fireVanguard = new Combatant("Ignis Warmaster", Element.FIRE, 10, 2000.0, 800.0);
        Combatant waterMender  = new Combatant("Tide Priestess", Element.WATER, 8, 1500.0, 950.0);
        Combatant earthBreaker = new Combatant("Lithic Titan", Element.EARTH, 6, 2500.0, 600.0);
        Combatant airDrifter   = new Combatant("Zephyr Sniper", Element.AIR, 9, 1200.0, 750.0);

        // Print Fire Nation progression grimoire showing all 10 tiers
        fireVanguard.printSkillBook();

        System.out.println(">>> COMBAT SIMULATION INITIALIZED <<<\n");

        // Scenario 1: Earth applies BRITTLE_EARTH, Fire follows up triggering MAGMA BLOOM
        earthBreaker.castSkill(3, fireVanguard); // Tremor Stomp -> applies BRITTLE_EARTH
        fireVanguard.castSkill(6, earthBreaker); // Molten Eruption -> triggers MAGMA BLOOM

        System.out.println("\n--------------------------------------------------\n");

        // Scenario 2: Water freezes target, Fire triggers catastrophic THERMAL SHOCK
        waterMender.castSkill(3, airDrifter);   // Frost Needle -> applies FROZEN
        fireVanguard.castSkill(10, airDrifter); // Avatar of the Sun -> triggers THERMAL SHOCK (x2.2 multiplier)

        System.out.println("\n--------------------------------------------------\n");

        // Scenario 3: Water applies WET, Air follows up triggering CONDUCTION
        waterMender.castSkill(1, earthBreaker); // Tide Whip -> applies WET
        airDrifter.castSkill(7, earthBreaker);   // Thunderhead Lance -> triggers CONDUCTION
    }
}