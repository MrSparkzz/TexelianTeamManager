package net.sparkzz.ttm;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Brendon on 8/6/2014.
 */
public class Fighter {

	private BufferedImage sprite = null;
	private FClass fclass = FClass.UNKNOWN;
	private int cooldownMAX = 0, cooldownMIN = 0;
	private int HP = 0, ATK = 0, DEF = 0, WIS = 0, AGI = 0;
	private int lvMIN = 0, lvMAX = 0;
	private int sef = 0;
	private Sign sign = Sign.UNKNOWN;
	private SkillBase base[] = {SkillBase.UNKNOWN, SkillBase.UNKNOWN};
	private SkillRank skillRank = SkillRank.UNKNOWN;
	private SkillTarget target[] = {SkillTarget.UNKNOWN, SkillTarget.UNKNOWN};
	private String name = "???";
	private String skill = "???";
	private Tier tier = Tier.UNKNOWN;
	private Tribe tribe = Tribe.UNKNOWN;

	enum FClass {
		UNKNOWN, CHAMP, ROGUE, GURU, WARLOCK, SCOUT;
	}

	enum Sign {
		UNKNOWN, FIRE, WATER, LIGHTNING, EARTH, AIR;
	}

	enum SkillBase {
		UNKNOWN, HP, ATK, WIS, AGI;
	}

	enum SkillRank {
		UNKNOWN, NOVICE, ADEPT, ELITE;
	}

	enum SkillTarget {
		UNKNOWN, ALL, NONE, SELF, SINGLE;
	}

	enum Tier {
		UNKNOWN(0), RARE(1), EPIC(2), LEGENDARY(3);

		int tier = 0;

		Tier(int tier) {
			this.tier = tier;
		}

		int getValue() {
			return tier;
		}
	}

	enum Tribe {
		UNKNOWN, XANA, HEMI, THERI;
	}

	public BufferedImage getSprite() {
		return this.sprite;
	}

	public void setSprite(String fighterName) {
		fighterName = fighterName.replaceAll(" ", "_");

		try {
			URL url = new URL("http://defenderoftexel.wikia.com/wiki/File:" + fighterName + "_Sprite.png");

			sprite = ImageIO.read(url);
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHP() {
		return this.HP;
	}

	public void setHP(int value) {
		this.HP = value;
	}

	public int getATK() {
		return this.ATK;
	}

	public void setATK(int value) {
		this.ATK = value;
	}

	public int getDEF() {
		return this.DEF;
	}

	public void setDEF(int value) {
		this.DEF = value;
	}

	public int getWIS() {
		return this.WIS;
	}

	public void setWIS(int value) {
		this.WIS = value;
	}

	public int getAGI() {
		return this.AGI;
	}

	public void setAGI(int value) {
		this.AGI = value;
	}

	public String getSkill() {
		return this.skill;
	}

	public void setSkill(String skillName) {
		this.skill = skillName;
	}

	public String getTarget(int skillNumber) {
		if (skillNumber == 1) {
			SkillTarget target = this.target[0];

			if (target.equals(SkillTarget.ALL)) return "All";
			if (target.equals(SkillTarget.SELF)) return "Self";
			if (target.equals(SkillTarget.SINGLE)) return "Single";
			if (target.equals(SkillTarget.UNKNOWN)) return "Unknown";
		}

		if (skillNumber == 2) {
			if (target.equals(SkillTarget.ALL)) return "All";
			if (target.equals(SkillTarget.NONE)) return "None";
			if (target.equals(SkillTarget.SELF)) return "Self";
			if (target.equals(SkillTarget.SINGLE)) return "Single";
			if (target.equals(SkillTarget.UNKNOWN)) return "Unknown";
		}

		return null;
	}

	public void setTarget(String target) {
		if (target.equalsIgnoreCase("all")) this.target[0] = SkillTarget.ALL;
		else if (target.equalsIgnoreCase("self")) this.target[0] = SkillTarget.SELF;
		else if (target.equalsIgnoreCase("single")) this.target[0] = SkillTarget.SINGLE;
		else this.target[0] = SkillTarget.UNKNOWN;
	}

	/*public void setTargetTwo(String target) {
		if (target.equalsIgnoreCase("all")) this.target[1] = SkillTarget.ALL;
		else if (target.equalsIgnoreCase("self")) this.target[1] = SkillTarget.SELF;
		else if (target.equalsIgnoreCase("single")) this.target[1] = SkillTarget.SINGLE;
		else this.target[1] = SkillTarget.NONE;
	}*/

	public String getSkillRank() {
		SkillRank rank = this.skillRank;

		if (rank.equals(SkillRank.ADEPT)) return "Adept";
		if (rank.equals(SkillRank.ELITE)) return "Elite";
		if (rank.equals(SkillRank.NOVICE)) return "Novice";
		if (rank.equals(SkillRank.UNKNOWN)) return "Unknown";

		return null;
	}

	public void setSkillRank(String rank) {
		if (rank.equalsIgnoreCase("adept")) this.skillRank = SkillRank.ADEPT;
		else if (rank.equalsIgnoreCase("elite")) this.skillRank = SkillRank.ELITE;
		else if (rank.equalsIgnoreCase("novice")) this.skillRank = SkillRank.NOVICE;
		else this.skillRank = SkillRank.UNKNOWN;
	}

	public int getCooldown() {
		return this.cooldownMAX;
	}

	public void setCooldown(String tier, int value) { // cooldown at SEF 5, 2 or 3
		setCooldownMAX(value);

		if (tier.equalsIgnoreCase("epic") || tier.equalsIgnoreCase("rare"))
			setCooldownMIN(value + 2);
		if (tier.equalsIgnoreCase("legendary")) setCooldownMIN(value + 1);
	}

	public void setCooldownMIN(int value) { // cooldown at SEF 0
		this.cooldownMIN = value;
	}

	public void setCooldownMAX(int value) {
		this.cooldownMAX = value;
	}

	public String getFClass() {
		FClass fClass = this.fclass;

		if (fClass.equals(FClass.CHAMP)) return "Champ";
		if (fClass.equals(FClass.GURU)) return "Guru";
		if (fClass.equals(FClass.ROGUE)) return "Rogue";
		if (fClass.equals(FClass.WARLOCK)) return "Warlock";
		if (fClass.equals(FClass.SCOUT)) return "Scout";

		return null;
	}

	public void setClass(String fighterClass) {
		if (fighterClass.equalsIgnoreCase("champ")) this.fclass = FClass.CHAMP;
		else if (fighterClass.equalsIgnoreCase("rogue")) this.fclass = FClass.ROGUE;
		else if (fighterClass.equalsIgnoreCase("guru")) this.fclass = FClass.GURU;
		else if (fighterClass.equalsIgnoreCase("warlock")) this.fclass = FClass.WARLOCK;
		else if (fighterClass.equalsIgnoreCase("scout")) this.fclass = FClass.SCOUT;
		else this.fclass = FClass.UNKNOWN;
	}

	public String getSign() {
		Sign sign = this.sign;

		if (sign.equals(Sign.AIR)) return "Air";
		if (sign.equals(Sign.EARTH)) return "Earth";
		if (sign.equals(Sign.FIRE)) return "Fire";
		if (sign.equals(Sign.LIGHTNING)) return "Lightning";
		if (sign.equals(Sign.WATER)) return "Water";

		return null;
	}

	/*public void setSign(String sign) {
		if (sign.equalsIgnoreCase("fire")) this.sign = Sign.FIRE;
		else if (sign.equalsIgnoreCase("water")) this.sign = Sign.WATER;
		else if (sign.equalsIgnoreCase("lightning")) this.sign = Sign.LIGHTNING;
		else if (sign.equalsIgnoreCase("earth")) this.sign = Sign.EARTH;
		else if (sign.equalsIgnoreCase("air")) this.sign = Sign.AIR;
		else this.sign = Sign.UNKNOWN;
	}*/

	public int getSEF() {
		return this.sef;
	}

	public void setSEF(int value) {
		this.sef = value;
	}

	public int getLvMIN() {
		return this.lvMIN;
	}

	public void setLvMIN(int value) {
		this.lvMIN = value;
	}

	public int getLvMAX() {
		return this.lvMAX;
	}

	public void setLvMAX(int value) {
		this.lvMAX = value;

		if (value == 80) setLvMIN(40);
		if (value == 100) setLvMIN(50);
		if (value == 84 || value == 96) setLvMIN(60);
		if (value == 112) setLvMIN(70);
	}

	public String parseEnum(Object object) {
		return "";
	}
}