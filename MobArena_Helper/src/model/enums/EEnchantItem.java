package model.enums;

import java.util.ArrayList;

/**
 * Les combinaisons disponibles enchantement/item
 *
 * @author Pyeroh
 *
 */
public enum EEnchantItem {

	// Armures
	ei1(EEnchantment.protection, EItem.leather_helmet),
	ei2(EEnchantment.protection, EItem.chainmail_helmet),
	ei3(EEnchantment.protection, EItem.iron_helmet),
	ei4(EEnchantment.protection, EItem.gold_helmet),
	ei5(EEnchantment.protection, EItem.diamond_helmet),
	ei6(EEnchantment.protection, EItem.leather_chestplate),
	ei7(EEnchantment.protection, EItem.chainmail_chestplate),
	ei8(EEnchantment.protection, EItem.iron_chestplate),
	ei9(EEnchantment.protection, EItem.gold_chestplate),
	ei10(EEnchantment.protection, EItem.diamond_chestplate),
	ei11(EEnchantment.protection, EItem.leather_leggings),
	ei12(EEnchantment.protection, EItem.chainmail_leggings),
	ei13(EEnchantment.protection, EItem.iron_leggings),
	ei14(EEnchantment.protection, EItem.gold_leggings),
	ei15(EEnchantment.protection, EItem.diamond_leggings),
	ei16(EEnchantment.protection, EItem.leather_boots),
	ei17(EEnchantment.protection, EItem.chainmail_boots),
	ei18(EEnchantment.protection, EItem.iron_boots),
	ei19(EEnchantment.protection, EItem.gold_boots),
	ei20(EEnchantment.protection, EItem.diamond_boots),
	ei262(EEnchantment.protection, EItem.enchanted_book),

	ei21(EEnchantment.fire_protection, EItem.leather_helmet),
	ei22(EEnchantment.fire_protection, EItem.chainmail_helmet),
	ei23(EEnchantment.fire_protection, EItem.iron_helmet),
	ei24(EEnchantment.fire_protection, EItem.gold_helmet),
	ei25(EEnchantment.fire_protection, EItem.diamond_helmet),
	ei26(EEnchantment.fire_protection, EItem.leather_chestplate),
	ei27(EEnchantment.fire_protection, EItem.chainmail_chestplate),
	ei28(EEnchantment.fire_protection, EItem.iron_chestplate),
	ei29(EEnchantment.fire_protection, EItem.gold_chestplate),
	ei30(EEnchantment.fire_protection, EItem.diamond_chestplate),
	ei31(EEnchantment.fire_protection, EItem.leather_leggings),
	ei32(EEnchantment.fire_protection, EItem.chainmail_leggings),
	ei33(EEnchantment.fire_protection, EItem.iron_leggings),
	ei34(EEnchantment.fire_protection, EItem.gold_leggings),
	ei35(EEnchantment.fire_protection, EItem.diamond_leggings),
	ei36(EEnchantment.fire_protection, EItem.leather_boots),
	ei37(EEnchantment.fire_protection, EItem.chainmail_boots),
	ei38(EEnchantment.fire_protection, EItem.iron_boots),
	ei39(EEnchantment.fire_protection, EItem.gold_boots),
	ei40(EEnchantment.fire_protection, EItem.diamond_boots),
	ei263(EEnchantment.fire_protection, EItem.enchanted_book),

	ei41(EEnchantment.feather_falling, EItem.leather_boots),
	ei42(EEnchantment.feather_falling, EItem.chainmail_boots),
	ei43(EEnchantment.feather_falling, EItem.iron_boots),
	ei44(EEnchantment.feather_falling, EItem.gold_boots),
	ei45(EEnchantment.feather_falling, EItem.diamond_boots),
	ei264(EEnchantment.feather_falling, EItem.enchanted_book),

	ei46(EEnchantment.blast_protection, EItem.leather_helmet),
	ei47(EEnchantment.blast_protection, EItem.chainmail_helmet),
	ei48(EEnchantment.blast_protection, EItem.iron_helmet),
	ei49(EEnchantment.blast_protection, EItem.gold_helmet),
	ei50(EEnchantment.blast_protection, EItem.diamond_helmet),
	ei51(EEnchantment.blast_protection, EItem.leather_chestplate),
	ei52(EEnchantment.blast_protection, EItem.chainmail_chestplate),
	ei53(EEnchantment.blast_protection, EItem.iron_chestplate),
	ei54(EEnchantment.blast_protection, EItem.gold_chestplate),
	ei55(EEnchantment.blast_protection, EItem.diamond_chestplate),
	ei56(EEnchantment.blast_protection, EItem.leather_leggings),
	ei57(EEnchantment.blast_protection, EItem.chainmail_leggings),
	ei58(EEnchantment.blast_protection, EItem.iron_leggings),
	ei59(EEnchantment.blast_protection, EItem.gold_leggings),
	ei60(EEnchantment.blast_protection, EItem.diamond_leggings),
	ei61(EEnchantment.blast_protection, EItem.leather_boots),
	ei62(EEnchantment.blast_protection, EItem.chainmail_boots),
	ei63(EEnchantment.blast_protection, EItem.iron_boots),
	ei64(EEnchantment.blast_protection, EItem.gold_boots),
	ei65(EEnchantment.blast_protection, EItem.diamond_boots),
	ei265(EEnchantment.blast_protection, EItem.enchanted_book),

	ei66(EEnchantment.projectile_protection, EItem.leather_helmet),
	ei67(EEnchantment.projectile_protection, EItem.chainmail_helmet),
	ei68(EEnchantment.projectile_protection, EItem.iron_helmet),
	ei69(EEnchantment.projectile_protection, EItem.gold_helmet),
	ei70(EEnchantment.projectile_protection, EItem.diamond_helmet),
	ei71(EEnchantment.projectile_protection, EItem.leather_chestplate),
	ei72(EEnchantment.projectile_protection, EItem.chainmail_chestplate),
	ei73(EEnchantment.projectile_protection, EItem.iron_chestplate),
	ei74(EEnchantment.projectile_protection, EItem.gold_chestplate),
	ei75(EEnchantment.projectile_protection, EItem.diamond_chestplate),
	ei76(EEnchantment.projectile_protection, EItem.leather_leggings),
	ei77(EEnchantment.projectile_protection, EItem.chainmail_leggings),
	ei78(EEnchantment.projectile_protection, EItem.iron_leggings),
	ei79(EEnchantment.projectile_protection, EItem.gold_leggings),
	ei80(EEnchantment.projectile_protection, EItem.diamond_leggings),
	ei81(EEnchantment.projectile_protection, EItem.leather_boots),
	ei82(EEnchantment.projectile_protection, EItem.chainmail_boots),
	ei83(EEnchantment.projectile_protection, EItem.iron_boots),
	ei84(EEnchantment.projectile_protection, EItem.gold_boots),
	ei85(EEnchantment.projectile_protection, EItem.diamond_boots),
	ei266(EEnchantment.projectile_protection, EItem.enchanted_book),

	ei86(EEnchantment.respiration, EItem.leather_helmet),
	ei87(EEnchantment.respiration, EItem.chainmail_helmet),
	ei88(EEnchantment.respiration, EItem.iron_helmet),
	ei89(EEnchantment.respiration, EItem.gold_helmet),
	ei90(EEnchantment.respiration, EItem.diamond_helmet),
	ei267(EEnchantment.respiration, EItem.enchanted_book),

	ei91(EEnchantment.aqua_affinity, EItem.leather_helmet),
	ei92(EEnchantment.aqua_affinity, EItem.chainmail_helmet),
	ei93(EEnchantment.aqua_affinity, EItem.iron_helmet),
	ei94(EEnchantment.aqua_affinity, EItem.gold_helmet),
	ei95(EEnchantment.aqua_affinity, EItem.diamond_helmet),
	ei268(EEnchantment.aqua_affinity, EItem.enchanted_book),

	ei96(EEnchantment.thorns, EItem.leather_helmet),
	ei97(EEnchantment.thorns, EItem.chainmail_helmet),
	ei98(EEnchantment.thorns, EItem.iron_helmet),
	ei99(EEnchantment.thorns, EItem.gold_helmet),
	ei100(EEnchantment.thorns, EItem.diamond_helmet),
	ei101(EEnchantment.thorns, EItem.leather_chestplate),
	ei102(EEnchantment.thorns, EItem.chainmail_chestplate),
	ei103(EEnchantment.thorns, EItem.iron_chestplate),
	ei104(EEnchantment.thorns, EItem.gold_chestplate),
	ei105(EEnchantment.thorns, EItem.diamond_chestplate),
	ei106(EEnchantment.thorns, EItem.leather_leggings),
	ei107(EEnchantment.thorns, EItem.chainmail_leggings),
	ei108(EEnchantment.thorns, EItem.iron_leggings),
	ei109(EEnchantment.thorns, EItem.gold_leggings),
	ei110(EEnchantment.thorns, EItem.diamond_leggings),
	ei111(EEnchantment.thorns, EItem.leather_boots),
	ei112(EEnchantment.thorns, EItem.chainmail_boots),
	ei113(EEnchantment.thorns, EItem.iron_boots),
	ei114(EEnchantment.thorns, EItem.gold_boots),
	ei115(EEnchantment.thorns, EItem.diamond_boots),
	ei269(EEnchantment.thorns, EItem.enchanted_book),

	// Armes
	ei116(EEnchantment.sharpness, EItem.wood_sword),
	ei117(EEnchantment.sharpness, EItem.stone_sword),
	ei118(EEnchantment.sharpness, EItem.iron_sword),
	ei119(EEnchantment.sharpness, EItem.gold_sword),
	ei120(EEnchantment.sharpness, EItem.diamond_sword),
	ei121(EEnchantment.sharpness, EItem.wood_axe),
	ei122(EEnchantment.sharpness, EItem.stone_axe),
	ei123(EEnchantment.sharpness, EItem.iron_axe),
	ei124(EEnchantment.sharpness, EItem.gold_axe),
	ei125(EEnchantment.sharpness, EItem.diamond_axe),
	ei270(EEnchantment.sharpness, EItem.enchanted_book),

	ei126(EEnchantment.smite, EItem.wood_sword),
	ei127(EEnchantment.smite, EItem.stone_sword),
	ei128(EEnchantment.smite, EItem.iron_sword),
	ei129(EEnchantment.smite, EItem.gold_sword),
	ei130(EEnchantment.smite, EItem.diamond_sword),
	ei131(EEnchantment.smite, EItem.wood_axe),
	ei132(EEnchantment.smite, EItem.stone_axe),
	ei133(EEnchantment.smite, EItem.iron_axe),
	ei134(EEnchantment.smite, EItem.gold_axe),
	ei135(EEnchantment.smite, EItem.diamond_axe),
	ei271(EEnchantment.smite, EItem.enchanted_book),

	ei136(EEnchantment.bane_of_arthropods, EItem.wood_sword),
	ei137(EEnchantment.bane_of_arthropods, EItem.stone_sword),
	ei138(EEnchantment.bane_of_arthropods, EItem.iron_sword),
	ei139(EEnchantment.bane_of_arthropods, EItem.gold_sword),
	ei140(EEnchantment.bane_of_arthropods, EItem.diamond_sword),
	ei141(EEnchantment.bane_of_arthropods, EItem.wood_axe),
	ei142(EEnchantment.bane_of_arthropods, EItem.stone_axe),
	ei143(EEnchantment.bane_of_arthropods, EItem.iron_axe),
	ei144(EEnchantment.bane_of_arthropods, EItem.gold_axe),
	ei145(EEnchantment.bane_of_arthropods, EItem.diamond_axe),
	ei272(EEnchantment.bane_of_arthropods, EItem.enchanted_book),

	ei146(EEnchantment.knockback, EItem.wood_sword),
	ei147(EEnchantment.knockback, EItem.stone_sword),
	ei148(EEnchantment.knockback, EItem.iron_sword),
	ei149(EEnchantment.knockback, EItem.gold_sword),
	ei150(EEnchantment.knockback, EItem.diamond_sword),
	ei273(EEnchantment.knockback, EItem.enchanted_book),

	ei151(EEnchantment.fire_aspect, EItem.wood_sword),
	ei152(EEnchantment.fire_aspect, EItem.stone_sword),
	ei153(EEnchantment.fire_aspect, EItem.iron_sword),
	ei154(EEnchantment.fire_aspect, EItem.gold_sword),
	ei155(EEnchantment.fire_aspect, EItem.diamond_sword),
	ei274(EEnchantment.fire_aspect, EItem.enchanted_book),

	ei156(EEnchantment.looting, EItem.wood_sword),
	ei157(EEnchantment.looting, EItem.stone_sword),
	ei158(EEnchantment.looting, EItem.iron_sword),
	ei159(EEnchantment.looting, EItem.gold_sword),
	ei160(EEnchantment.looting, EItem.diamond_sword),
	ei275(EEnchantment.looting, EItem.enchanted_book),

	ei161(EEnchantment.power, EItem.bow),
	ei162(EEnchantment.punch, EItem.bow),
	ei163(EEnchantment.flame, EItem.bow),
	ei164(EEnchantment.infinity, EItem.bow),
	ei276(EEnchantment.infinity, EItem.enchanted_book),

	// Outils
	ei165(EEnchantment.efficiency, EItem.wood_pickaxe),
	ei166(EEnchantment.efficiency, EItem.stone_pickaxe),
	ei167(EEnchantment.efficiency, EItem.iron_pickaxe),
	ei168(EEnchantment.efficiency, EItem.gold_pickaxe),
	ei169(EEnchantment.efficiency, EItem.diamond_pickaxe),
	ei170(EEnchantment.efficiency, EItem.wood_spade),
	ei171(EEnchantment.efficiency, EItem.stone_spade),
	ei172(EEnchantment.efficiency, EItem.iron_spade),
	ei173(EEnchantment.efficiency, EItem.gold_spade),
	ei174(EEnchantment.efficiency, EItem.diamond_spade),
	ei175(EEnchantment.efficiency, EItem.wood_axe),
	ei176(EEnchantment.efficiency, EItem.stone_axe),
	ei177(EEnchantment.efficiency, EItem.iron_axe),
	ei178(EEnchantment.efficiency, EItem.gold_axe),
	ei179(EEnchantment.efficiency, EItem.diamond_axe),
	ei180(EEnchantment.efficiency, EItem.shears),
	ei277(EEnchantment.efficiency, EItem.enchanted_book),

	ei181(EEnchantment.silk_touch, EItem.wood_pickaxe),
	ei182(EEnchantment.silk_touch, EItem.stone_pickaxe),
	ei183(EEnchantment.silk_touch, EItem.iron_pickaxe),
	ei184(EEnchantment.silk_touch, EItem.gold_pickaxe),
	ei185(EEnchantment.silk_touch, EItem.diamond_pickaxe),
	ei186(EEnchantment.silk_touch, EItem.wood_spade),
	ei187(EEnchantment.silk_touch, EItem.stone_spade),
	ei188(EEnchantment.silk_touch, EItem.iron_spade),
	ei189(EEnchantment.silk_touch, EItem.gold_spade),
	ei190(EEnchantment.silk_touch, EItem.diamond_spade),
	ei191(EEnchantment.silk_touch, EItem.wood_axe),
	ei192(EEnchantment.silk_touch, EItem.stone_axe),
	ei193(EEnchantment.silk_touch, EItem.iron_axe),
	ei194(EEnchantment.silk_touch, EItem.gold_axe),
	ei195(EEnchantment.silk_touch, EItem.diamond_axe),
	ei196(EEnchantment.silk_touch, EItem.shears),
	ei278(EEnchantment.silk_touch, EItem.enchanted_book),

	ei197(EEnchantment.unbreaking, EItem.wood_pickaxe),
	ei198(EEnchantment.unbreaking, EItem.stone_pickaxe),
	ei199(EEnchantment.unbreaking, EItem.iron_pickaxe),
	ei200(EEnchantment.unbreaking, EItem.gold_pickaxe),
	ei201(EEnchantment.unbreaking, EItem.diamond_pickaxe),
	ei202(EEnchantment.unbreaking, EItem.wood_spade),
	ei203(EEnchantment.unbreaking, EItem.stone_spade),
	ei204(EEnchantment.unbreaking, EItem.iron_spade),
	ei205(EEnchantment.unbreaking, EItem.gold_spade),
	ei206(EEnchantment.unbreaking, EItem.diamond_spade),
	ei207(EEnchantment.unbreaking, EItem.wood_axe),
	ei208(EEnchantment.unbreaking, EItem.stone_axe),
	ei209(EEnchantment.unbreaking, EItem.iron_axe),
	ei210(EEnchantment.unbreaking, EItem.gold_axe),
	ei211(EEnchantment.unbreaking, EItem.wood_hoe),
	ei212(EEnchantment.unbreaking, EItem.stone_hoe),
	ei213(EEnchantment.unbreaking, EItem.iron_hoe),
	ei214(EEnchantment.unbreaking, EItem.gold_hoe),
	ei215(EEnchantment.unbreaking, EItem.diamond_hoe),
	ei216(EEnchantment.unbreaking, EItem.wood_sword),
	ei217(EEnchantment.unbreaking, EItem.stone_sword),
	ei218(EEnchantment.unbreaking, EItem.iron_sword),
	ei219(EEnchantment.unbreaking, EItem.gold_sword),
	ei220(EEnchantment.unbreaking, EItem.diamond_sword),
	ei221(EEnchantment.unbreaking, EItem.leather_helmet),
	ei222(EEnchantment.unbreaking, EItem.chainmail_helmet),
	ei223(EEnchantment.unbreaking, EItem.iron_helmet),
	ei224(EEnchantment.unbreaking, EItem.gold_helmet),
	ei225(EEnchantment.unbreaking, EItem.diamond_helmet),
	ei226(EEnchantment.unbreaking, EItem.leather_chestplate),
	ei227(EEnchantment.unbreaking, EItem.chainmail_chestplate),
	ei228(EEnchantment.unbreaking, EItem.iron_chestplate),
	ei229(EEnchantment.unbreaking, EItem.gold_chestplate),
	ei230(EEnchantment.unbreaking, EItem.diamond_chestplate),
	ei231(EEnchantment.unbreaking, EItem.leather_leggings),
	ei232(EEnchantment.unbreaking, EItem.chainmail_leggings),
	ei233(EEnchantment.unbreaking, EItem.iron_leggings),
	ei234(EEnchantment.unbreaking, EItem.gold_leggings),
	ei235(EEnchantment.unbreaking, EItem.diamond_leggings),
	ei236(EEnchantment.unbreaking, EItem.leather_boots),
	ei237(EEnchantment.unbreaking, EItem.chainmail_boots),
	ei238(EEnchantment.unbreaking, EItem.iron_boots),
	ei239(EEnchantment.unbreaking, EItem.gold_boots),
	ei240(EEnchantment.unbreaking, EItem.diamond_boots),
	ei241(EEnchantment.unbreaking, EItem.bow),
	ei242(EEnchantment.unbreaking, EItem.shears),
	ei243(EEnchantment.unbreaking, EItem.fishing_rod),
	ei244(EEnchantment.unbreaking, EItem.flint_and_steel),
	ei245(EEnchantment.unbreaking, EItem.carrot_on_a_stick),
	ei279(EEnchantment.unbreaking, EItem.enchanted_book),

	ei246(EEnchantment.fortune, EItem.wood_pickaxe),
	ei247(EEnchantment.fortune, EItem.stone_pickaxe),
	ei248(EEnchantment.fortune, EItem.iron_pickaxe),
	ei249(EEnchantment.fortune, EItem.gold_pickaxe),
	ei250(EEnchantment.fortune, EItem.diamond_pickaxe),
	ei251(EEnchantment.fortune, EItem.wood_spade),
	ei252(EEnchantment.fortune, EItem.stone_spade),
	ei253(EEnchantment.fortune, EItem.iron_spade),
	ei254(EEnchantment.fortune, EItem.gold_spade),
	ei255(EEnchantment.fortune, EItem.diamond_spade),
	ei256(EEnchantment.fortune, EItem.wood_axe),
	ei257(EEnchantment.fortune, EItem.stone_axe),
	ei258(EEnchantment.fortune, EItem.iron_axe),
	ei259(EEnchantment.fortune, EItem.gold_axe),
	ei280(EEnchantment.fortune, EItem.enchanted_book),

	ei260(EEnchantment.luck_of_the_sea, EItem.fishing_rod),
	ei281(EEnchantment.luck_of_the_sea, EItem.enchanted_book),
	ei261(EEnchantment.lure, EItem.fishing_rod),
	ei282(EEnchantment.lure, EItem.enchanted_book), ;

	private EEnchantment enchantment;

	private EItem item;

	private EEnchantItem(EEnchantment enchantment, EItem item) {
		this.enchantment = enchantment;
		this.item = item;
	}

	public EEnchantment getEnchantment() {
		return enchantment;
	}

	public EItem getItem() {
		return item;
	}

	/**
	 * Renvoie touts les items qui sont enchantables par l'enchantement passé en paramètre
	 *
	 * @param enchant
	 * @return
	 */
	public static ArrayList<EItem> getByEnchant(EEnchantment enchant) {
		ArrayList<EItem> items = new ArrayList<EItem>();
		EEnchantItem[] values = values();

		for (int i = 0; i < values.length; i++) {
			if (values[i].getEnchantment() == enchant)
				items.add(values[i].getItem());
		}

		return items;
	}

	/**
	 * Renvoie tous les enchantements qui sont applicable à l'item passé en paramètre
	 *
	 * @param eitem
	 * @return
	 */
	public static ArrayList<EEnchantment> getByItem(EItem eitem) {
		ArrayList<EEnchantment> enchants = new ArrayList<EEnchantment>();
		EEnchantItem[] values = values();

		for (int i = 0; i < values.length; i++) {
			if (values[i].getItem() == eitem)
				enchants.add(values[i].getEnchantment());
		}

		return enchants;
	}

}
