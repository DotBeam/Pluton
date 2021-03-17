package de.beam.Pluton.Api;


import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Itembuilder {
  @SuppressWarnings("deprecation")
public static ItemStack Items(final Material material, final int anzal,final int shortid,String Name,String lore){
         ItemStack i = new ItemStack(material, anzal,(short)shortid);
         ItemMeta im = i.getItemMeta();
         im.setDisplayName(Name);
         im.setLore(Arrays.asList(new String[] {lore}));
         im.spigot().setUnbreakable(true);
         i.setItemMeta(im);
         return i;
     }
  @SuppressWarnings("deprecation")
public static ItemStack GlowItem(final Material material, final int anzal,final int shortid,String Name,String lore){
      ItemStack i = new ItemStack(material, anzal,(short)shortid);
      ItemMeta im = i.getItemMeta();
      im.setDisplayName(Name);
      im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
      im.addEnchant(Enchantment.DURABILITY, 1, true);
      im.setLore(Arrays.asList(new String[] {lore}));
      im.spigot().setUnbreakable(true);
      i.setItemMeta(im);
      return i;
  }
  public static ItemStack Itemsohneum(final Material material, final int anzal,final int shortid,String Name,String lore){
      ItemStack i = new ItemStack(material, anzal,(short)shortid);
      ItemMeta im = i.getItemMeta();
      im.setDisplayName(Name);
      im.setLore(Arrays.asList(new String[] {lore}));
      i.setItemMeta(im);
      return i;
  }
   @SuppressWarnings("deprecation")
public static ItemStack leatherArmor( final Material material, String displayname,final Color color, String lore)
   {

       ItemStack i = new ItemStack(material);
       LeatherArmorMeta im = (LeatherArmorMeta)i.getItemMeta();
       im.setColor(color);
       im.setDisplayName(displayname);
       im.setLore(Arrays.asList(new String[]{lore}));
       im.spigot().setUnbreakable(true);
       i.setItemMeta(im);
       return i;
   }
   @SuppressWarnings("deprecation")
public static ItemStack Glow( final Material material, String displayname,final Color color, String lore)
   {

       ItemStack i = new ItemStack(material);
       LeatherArmorMeta im = (LeatherArmorMeta)i.getItemMeta();
       im.setColor(color);
       im.setDisplayName(displayname);
       im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
       im.addEnchant(Enchantment.DURABILITY, 1, true);
       im.setLore(Arrays.asList(new String[]{lore}));
       im.spigot().setUnbreakable(true);
       i.setItemMeta(im);
       return i;
   }

   public static Inventory fillInventory(Inventory inv, ItemStack filling) {
       for(int i = 0; i < inv.getSize(); i++) {
           inv.setItem(i, filling);
       }
       return inv;
   }
       @SuppressWarnings("deprecation")
	public static ItemStack ItemsID(int id,String name,String lore,int shortid){
       ItemStack i = new ItemStack(id,1,(short)shortid);
       ItemMeta im = i.getItemMeta();
       im.setDisplayName(name);
       im.setLore(Arrays.asList(new String[] {lore}));
       i.setItemMeta(im);
       return i;
   }
   @SuppressWarnings("deprecation")
public static ItemStack Skull(String name,String Owner,String lore){
	   ItemStack i = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
	   SkullMeta im = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
           im.setOwner(Owner);
           im.setDisplayName(name);
           im.setLore(Arrays.asList(new String[] {lore}));
           i.setItemMeta(im);
           return i;
       }
   @SuppressWarnings("deprecation")
public static ItemStack Banner(String name,DyeColor color){
	   ItemStack i = new ItemStack(Material.BANNER, 1);
	   BannerMeta bm = (BannerMeta) i.getItemMeta();
	   bm.setBaseColor(color);
	   i.setItemMeta(bm);
	   return i;
   
   
   
   }
   
}
