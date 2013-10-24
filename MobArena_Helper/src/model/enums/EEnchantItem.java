package model.enums;

public enum EEnchantItem {
	
	//Armures
	ei1(EEnchantment.protection,null),
	ei2(EEnchantment.protection,null),
	ei3(EEnchantment.protection,null),
	ei4(EEnchantment.protection,null),
	ei5(EEnchantment.fire_protection,null),
	ei6(EEnchantment.fire_protection,null),
	ei7(EEnchantment.fire_protection,null),
	ei8(EEnchantment.fire_protection,null),
	ei9(EEnchantment.feather_falling,null),
	ei10(EEnchantment.blast_protection,null),
	ei11(EEnchantment.blast_protection,null),
	ei12(EEnchantment.blast_protection,null),
	ei13(EEnchantment.blast_protection,null),
	ei14(EEnchantment.projectile_protection,null),
	ei15(EEnchantment.projectile_protection,null),
	ei16(EEnchantment.projectile_protection,null),
	ei17(EEnchantment.projectile_protection,null),
	ei18(EEnchantment.respiration,null),
	ei19(EEnchantment.aqua_affinity,null),
	ei20(EEnchantment.thorns,null),
	ei21(EEnchantment.thorns,null),
	ei22(EEnchantment.thorns,null),
	ei23(EEnchantment.thorns,null),
	
	//Armes
	ei24(null,null),
	ei25(null,null),
	ei26(null,null),
	ei27(null,null),
	ei28(null,null),
	ei29(null,null),
	ei30(null,null),
	ei31(null,null),
	ei32(null,null),
	ei33(null,null),
	ei34(null,null),
	ei35(null,null),
	ei36(null,null),
	
	//Outils
	ei37(null,null),
	ei38(null,null),
	ei39(null,null),
	ei40(null,null),
	ei41(null,null),
	ei42(null,null),
	ei43(null,null),
	ei44(null,null),
	ei45(null,null),
	ei46(null,null),
	ei47(null,null),
	ei48(null,null),
	ei49(null,null),
	ei50(null,null),
	ei51(null,null),
	ei52(null,null),
	ei53(null,null),
	ei54(null,null),
	ei55(null,null),
	ei56(null,null),
	ei57(null,null),
	ei58(null,null),
	ei59(null,null),
	ei60(null,null),
	ei61(null,null),
	//ei62(EEnchantment.luck_of_the_sea,EItem.fishing_rod),
	//ei63(EEnchantment.lure,EItem.fishing_rod),
	;
	
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
	
}
