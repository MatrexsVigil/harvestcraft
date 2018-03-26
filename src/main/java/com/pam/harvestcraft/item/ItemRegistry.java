package com.pam.harvestcraft.item;

import static com.pam.harvestcraft.HarvestCraft.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.pam.harvestcraft.HarvestCraft;
import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.blocks.FruitRegistry;
import com.pam.harvestcraft.blocks.blocks.BlockPamCake;
import com.pam.harvestcraft.config.ConfigHandler;
import com.pam.harvestcraft.item.items.ItemPamBee;
import com.pam.harvestcraft.item.items.ItemPamCakeFood;
import com.pam.harvestcraft.item.items.ItemPamCropBag;
import com.pam.harvestcraft.item.items.ItemPamFood;
import com.pam.harvestcraft.item.items.ItemPamPotionFood;
import com.pam.harvestcraft.item.items.ItemPamTool;
import com.pam.harvestcraft.item.items.ItemPamTopTierFood;

import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

public final class ItemRegistry {
	public static final List<Item> itemlist = new ArrayList<Item>();
    public static final HashMap<String, Item> items = new HashMap<String, Item>();

	public static final HashSet<Item> allFishRaw = new HashSet<Item>();
	public static final HashSet<Item> allFood = new HashSet<Item>();
	public static final HashSet<Item> allJuice = new HashSet<Item>();
	
	

	// Items
	public static Item cuttingboardItem;
	public static Item potItem;
	public static Item skilletItem;
	public static Item saucepanItem;
	public static Item bakewareItem;
	public static Item mortarandpestleItem;
	public static Item mixingbowlItem;
	public static Item juicerItem;
	public static Item honeyItem;
	public static Item saltItem;
	public static Item wovencottonItem;
	public static Item freshwaterItem;
	public static Item freshmilkItem;
	public static Item calamarirawItem;
	public static Item calamaricookedItem;
	
	public static Item garliccoinItem;
	
	public static Item harvestappleItem;
	public static Item harvestwheatItem;
	public static ItemSeedFood harvestpotatoItem;
	public static ItemSeedFood harvestcarrotItem;
	public static Item harvestbeetItem;
	public static Item harvestmelonItem;
	public static Item harvestpumpkinItem;
	
	public static Item harvestbeefItem;
	public static Item harvestcookedbeefItem;
	public static Item harvestchickenItem;
	public static Item harvestcookedchickenItem;
	public static Item harvestporkchopItem;
	public static Item harvestcookedporkchopItem;
	public static Item harvestrabbitItem;
	public static Item harvestcookedrabbitItem;
	public static Item harvestmuttonItem;
	public static Item harvestcookedmuttonItem;
	public static Item harvestfishItem;
	public static Item harvestcookedfishedItem;
	public static Item harvestsalmonItem;
	public static Item harvestcookedsalmonfishedItem;
	public static Item harvestclownfishItem;
	public static Item harvestpufferfishItem;
	
	public static Item harvestmushroomstewItem;
	public static Item harvestbreadItem;
	public static Item harvestcookieItem;
	public static Item harvestbakedpotatoItem;
	public static Item pumpkinpieItem;
	public static Item rabbitstewItem;
	public static Item beetrootsoupItem;
	
	
	//public static Item seedbagItem;
	//public static Item cropbagItem;
	//public static Item saplingbagItem;

	public static Item grilledasparagusItem;
	public static Item bakedsweetpotatoItem;
	public static Item teaItem;
	public static Item coffeeItem;
	public static Item popcornItem;
	public static Item grilledeggplantItem;
	public static Item raisinsItem;
	public static Item ricecakeItem;
	public static Item toastedcoconutItem;
	public static Item vanillaItem;
	public static Item toastedsesameseedsItem;
	public static Item flourItem;
	public static Item doughItem;
	public static Item toastItem;
	public static Item pastaItem;
	public static Item heavycreamItem;
	public static Item butterItem;
	public static Item cheeseItem;
	public static Item icecreamItem;
	public static Item grilledcheeseItem;
	public static Item applesauceItem;
	public static Item applepieItem;
	public static Item caramelappleItem;
	public static Item pumpkinbreadItem;
	public static Item roastedpumpkinseedsItem;
	public static Item pumpkinsoupItem;
	public static Item melonsmoothieItem;

	public static Item carrotsoupItem;
	public static Item glazedcarrotsItem;
	public static Item butteredpotatoItem;
	public static Item loadedbakedpotatoItem;
	public static Item mashedpotatoesItem;
	public static Item potatosaladItem;
	public static Item potatosoupItem;
	public static Item friesItem;
	public static Item grilledmushroomItem;
	public static Item stuffedmushroomItem;
	public static Item chickensandwichItem;
	public static Item chickennoodlesoupItem;
	public static Item chickenpotpieItem;
	public static Item breadedporkchopItem;
	public static Item hotdogItem;
	public static Item bakedhamItem;
	public static Item hamburgerItem;
	public static Item cheeseburgerItem;
	public static Item baconcheeseburgerItem;
	public static Item potroastItem;
	public static Item fishsandwichItem;
	public static Item fishsticksItem;
	public static Item fishandchipsItem;
	public static Item mayoItem;
	public static Item friedeggItem;
	public static Item scrambledeggItem;
	public static Item boiledeggItem;
	public static Item eggsaladItem;
	public static Item caramelItem;
	public static Item taffyItem;
	public static Item spidereyesoupItem;
	public static Item zombiejerkyItem;
	public static Item cocoapowderItem;
	public static Item chocolatebarItem;
	public static Item hotchocolateItem;
	public static Item chocolateicecreamItem;
	public static Item vegetablesoupItem;
	public static Item stockItem;
	public static Item fruitsaladItem;
	public static Item spagettiItem;
	public static Item spagettiandmeatballsItem;
	public static Item tomatosoupItem;
	public static Item ketchupItem;
	public static Item chickenparmasanItem;
	public static Item pizzaItem;
	public static Item springsaladItem;
	public static Item porklettucewrapItem;
	public static Item fishlettucewrapItem;
	public static Item bltItem;
	public static Item leafychickensandwichItem;
	public static Item leafyfishsandwichItem;
	public static Item deluxecheeseburgerItem;
	public static Item delightedmealItem;
	public static Item onionsoupItem;
	public static Item potatocakesItem;
	public static Item hashItem;
	public static Item braisedonionsItem;
	public static Item heartybreakfastItem;
	public static Item cornonthecobItem;
	public static Item cornmealItem;
	public static Item cornbreadItem;
	public static Item tortillaItem;
	public static Item nachoesItem;
	public static Item tacoItem;
	public static Item fishtacoItem;
	public static Item creamedcornItem;
	public static Item strawberrysmoothieItem;
	public static Item strawberrypieItem;
	public static Item strawberrysaladItem;
	public static Item chocolatestrawberryItem;
	public static Item peanutbutterItem;
	public static Item trailmixItem;
	public static Item pbandjItem;
	public static Item peanutbuttercookiesItem;
	public static Item vinegarItem;
	public static Item grapejellyItem;
	public static Item grapesaladItem;
	public static Item raisincookiesItem;
	public static Item picklesItem;
	public static Item cucumbersaladItem;
	public static Item cucumbersoupItem;
	public static Item vegetarianlettucewrapItem;
	public static Item marinatedcucumbersItem;
	public static Item ricesoupItem;
	public static Item friedriceItem;
	public static Item mushroomrisottoItem;
	public static Item curryItem;
	public static Item rainbowcurryItem;
	public static Item refriedbeansItem;
	public static Item bakedbeansItem;
	public static Item beansandriceItem;
	public static Item chiliItem;
	public static Item beanburritoItem;
	public static Item stuffedpepperItem;
	public static Item veggiestirfryItem;
	public static Item grilledskewersItem;
	public static Item supremepizzaItem;
	public static Item omeletItem;
	public static Item hotwingsItem;
	public static Item chilipoppersItem;
	public static Item extremechiliItem;
	public static Item chilichocolateItem;
	public static Item lemonaideItem;
	public static Item lemonbarItem;
	public static Item fishdinnerItem;
	public static Item lemonsmoothieItem;
	public static Item lemonmeringueItem;
	public static Item candiedlemonItem;
	public static Item lemonchickenItem;
	public static Item blueberrysmoothieItem;
	public static Item blueberrypieItem;
	public static Item blueberrymuffinItem;
	public static Item pancakesItem;
	public static Item blueberrypancakesItem;
	public static Item cherrypieItem;
	public static Item chocolatecherryItem;
	public static Item cherrysmoothieItem;

	public static Item stuffedeggplantItem;
	public static Item eggplantparmItem;
	public static Item raspberryicedteaItem;
	public static Item chaiteaItem;
	public static Item espressoItem;
	public static Item coffeeconlecheItem;
	public static Item mochaicecreamItem;
	public static Item pickledbeetsItem;
	public static Item beetsaladItem;
	public static Item beetsoupItem;
	public static Item bakedbeetsItem;
	public static Item broccolimacItem;
	public static Item broccolindipItem;
	public static Item creamedbroccolisoupItem;
	public static Item sweetpotatopieItem;
	public static Item candiedsweetpotatoesItem;
	public static Item mashedsweetpotatoesItem;
	public static Item steamedpeasItem;
	public static Item splitpeasoupItem;

	public static Item pineapplehamItem;
	public static Item pineappleyogurtItem;
	public static Item turnipsoupItem;
	public static Item roastedrootveggiemedleyItem;
	public static Item bakedturnipsItem;
	public static Item gingerbreadItem;
	public static Item gingersnapsItem;
	public static Item candiedgingerItem;
	public static Item mustardItem;
	public static Item softpretzelandmustardItem;
	public static Item spicymustardporkItem;
	public static Item spicygreensItem;
	public static Item garlicbreadItem;
	public static Item garlicmashedpotatoesItem;
	public static Item garlicchickenItem;
	public static Item summerradishsaladItem;
	public static Item summersquashwithradishItem;
	public static Item celeryandpeanutbutterItem;
	public static Item chickencelerycasseroleItem;
	public static Item peasandceleryItem;
	public static Item celerysoupItem;
	public static Item zucchinibreadItem;
	public static Item zucchinifriesItem;
	public static Item zestyzucchiniItem;
	public static Item zucchinibakeItem;
	public static Item asparagusquicheItem;
	public static Item asparagussoupItem;
	public static Item walnutraisinbreadItem;
	public static Item candiedwalnutsItem;
	public static Item brownieItem;
	public static Item papayasmoothieItem;
	public static Item papayayogurtItem;
	public static Item starfruitsmoothieItem;
	public static Item starfruityogurtItem;
	public static Item guacamoleItem;
	public static Item creamofavocadosoupItem;
	public static Item avocadoburritoItem;
	public static Item poachedpearItem;
	public static Item fruitcrumbleItem;
	public static Item pearyogurtItem;
	public static Item plumyogurtItem;
	public static Item bananasplitItem;
	public static Item banananutbreadItem;
	public static Item bananasmoothieItem;
	public static Item bananayogurtItem;
	public static Item coconutmilkItem;
	public static Item chickencurryItem;
	public static Item coconutshrimpItem;
	public static Item coconutyogurtItem;
	public static Item orangechickenItem;
	public static Item orangesmoothieItem;
	public static Item orangeyogurtItem;
	public static Item peachcobblerItem;
	public static Item peachsmoothieItem;
	public static Item peachyogurtItem;
	public static Item keylimepieItem;
	public static Item limesmoothieItem;
	public static Item limeyogurtItem;
	public static Item mangosmoothieItem;
	public static Item mangoyogurtItem;
	public static Item pomegranatesmoothieItem;
	public static Item pomegranateyogurtItem;
	public static Item vanillayogurtItem;
	public static Item cinnamonrollItem;
	public static Item frenchtoastItem;
	public static Item marshmellowsItem;
	public static Item donutItem;
	public static Item chocolatedonutItem;
	public static Item powdereddonutItem;
	public static Item jellydonutItem;
	public static Item frosteddonutItem;
	public static Item cactussoupItem;
	public static Item wafflesItem;
	public static Item seedsoupItem;
	public static Item softpretzelItem;
	public static Item jellybeansItem;
	public static Item biscuitItem;
	public static Item creamcookieItem;
	public static Item jaffaItem;
	public static Item friedchickenItem;

	public static Item footlongItem;
	public static Item blueberryyogurtItem;
	public static Item lemonyogurtItem;
	public static Item cherryyogurtItem;
	public static Item strawberryyogurtItem;
	public static Item grapeyogurtItem;
	public static Item chocolateyogurtItem;
	public static Item blackberrycobblerItem;
	public static Item blackberrysmoothieItem;
	public static Item blackberryyogurtItem;
	public static Item chocolatemilkItem;
	public static Item pumpkinyogurtItem;
	public static Item raspberrypieItem;
	public static Item raspberrysmoothieItem;
	public static Item raspberryyogurtItem;
	public static Item cinnamonsugardonutItem;
	public static Item melonyogurtItem;
	public static Item kiwismoothieItem;
	public static Item kiwiyogurtItem;
	public static Item plainyogurtItem;
	public static Item appleyogurtItem;
	public static Item saltedsunflowerseedsItem;
	public static Item sunflowerwheatrollsItem;
	public static Item sunflowerbroccolisaladItem;
	public static Item cranberrysauceItem;
	public static Item cranberrybarItem;
	public static Item peppermintItem;
	public static Item blackpepperItem;
	public static Item groundcinnamonItem;
	public static Item groundnutmegItem;
	public static Item oliveoilItem;
	public static Item baklavaItem;
	public static Item gummybearsItem;
	public static Item baconmushroomburgerItem;
	public static Item fruitpunchItem;
	public static Item meatystewItem;
	public static Item mixedsaladItem;
	public static Item pinacoladaItem;
	public static Item saladdressingItem;
	public static Item shepardspieItem;
	public static Item eggnogItem;
	public static Item custardItem;
	public static Item sushiItem;
	public static Item gardensoupItem;
	public static Item applejellyItem;
	public static Item applejellysandwichItem;
	public static Item blackberryjellyItem;
	public static Item blackberryjellysandwichItem;
	public static Item blueberryjellyItem;
	public static Item blueberryjellysandwichItem;
	public static Item cherryjellyItem;
	public static Item cherryjellysandwichItem;
	public static Item cranberryjellyItem;
	public static Item cranberryjellysandwichItem;
	public static Item kiwijellyItem;
	public static Item kiwijellysandwichItem;
	public static Item lemonjellyItem;
	public static Item lemonjellysandwichItem;
	public static Item limejellyItem;
	public static Item limejellysandwichItem;
	public static Item mangojellyItem;
	public static Item mangojellysandwichItem;
	public static Item orangejellyItem;
	public static Item orangejellysandwichItem;
	public static Item papayajellyItem;
	public static Item papayajellysandwichItem;
	public static Item peachjellyItem;
	public static Item peachjellysandwichItem;
	public static Item pomegranatejellyItem;
	public static Item pomegranatejellysandwichItem;
	public static Item raspberryjellyItem;
	public static Item raspberryjellysandwichItem;
	public static Item starfruitjellyItem;
	public static Item starfruitjellysandwichItem;
	public static Item strawberryjellyItem;
	public static Item strawberryjellysandwichItem;
	public static Item watermelonjellyItem;
	public static Item watermelonjellysandwichItem;
	public static Item bubblywaterItem;
	public static Item cherrysodaItem;
	public static Item colasodaItem;
	public static Item gingersodaItem;
	public static Item grapesodaItem;
	public static Item lemonlimesodaItem;
	public static Item orangesodaItem;
	public static Item rootbeersodaItem;
	public static Item strawberrysodaItem;
	public static Item mintchocolatechipicemcreamItem;
	public static Item strawberryicecreamItem;
	public static Item vanillaicecreamItem;
	public static Item gingerchickenItem;
	public static Item oldworldveggiesoupItem;
	public static Item spicebunItem;
	public static Item gingeredrhubarbtartItem;
	public static Item lambbarleysoupItem;
	public static Item honeylemonlambItem;
	public static Item pumpkinoatsconesItem;
	public static Item ovenroastedcauliflowerItem;
	public static Item leekbaconsoupItem;
	public static Item herbbutterparsnipsItem;
	public static Item scallionbakedpotatoItem;
	public static Item soymilkItem;
	public static Item firmtofuItem;
	public static Item silkentofuItem;
	public static Item bamboosteamedriceItem;
	public static Item roastedchestnutItem;
	public static Item sweetpotatosouffleItem;
	public static Item cashewchickenItem;
	public static Item apricotyogurtItem;
	public static Item apricotglazedporkItem;
	public static Item apricotjellyItem;
	public static Item apricotjellysandwichItem;
	public static Item apricotsmoothieItem;
	public static Item figbarItem;
	public static Item figjellyItem;
	public static Item figjellysandwichItem;
	public static Item figsmoothieItem;
	public static Item figyogurtItem;
	public static Item grapefruitjellyItem;
	public static Item grapefruitjellysandwichItem;
	public static Item grapefruitsmoothieItem;
	public static Item grapefruityogurtItem;
	public static Item grapefruitsodaItem;
	public static Item citrussaladItem;
	public static Item pecanpieItem;
	public static Item pralinesItem;
	public static Item persimmonyogurtItem;
	public static Item persimmonsmoothieItem;
	public static Item persimmonjellyItem;
	public static Item persimmonjellysandwichItem;
	public static Item pistachiobakedsalmonItem;
	public static Item baconwrappeddatesItem;
	public static Item datenutbreadItem;
	public static Item maplesyruppancakesItem;
	public static Item maplesyrupwafflesItem;
	public static Item maplesausageItem;
	public static Item mapleoatmealItem;
	public static Item peachesandcreamoatmealItem;
	public static Item cinnamonappleoatmealItem;
	public static Item maplecandiedbaconItem;
	public static Item toastsandwichItem;
	public static Item potatoandcheesepirogiItem;
	public static Item zeppoleItem;
	public static Item sausageinbreadItem;
	public static Item chocolatecaramelfudgeItem;
	public static Item lavendershortbreadItem;
	public static Item beefwellingtonItem;
	public static Item epicbaconItem;
	public static Item manjuuItem;
	public static Item chickengumboItem;
	public static Item generaltsochickenItem;
	public static Item californiarollItem;
	public static Item futomakiItem;
	public static Item beansontoastItem;
	public static Item vegemiteItem;
	public static Item honeycombchocolatebarItem;
	public static Item cherrycoconutchocolatebarItem;
	public static Item fairybreadItem;

	public static Item timtamItem;
	public static Item meatpieItem;
	public static Item chikorollItem;
	public static Item damperItem;
	public static Item beetburgerItem;

	public static Item gherkinItem;
	public static Item mcpamItem;
	public static Item ceasarsaladItem;
	public static Item chaoscookieItem;
	public static Item chocolatebaconItem;
	public static Item lambkebabItem;
	public static Item nutellaItem;
	public static Item snickersbarItem;
	public static Item spinachpieItem;
	public static Item steamedspinachItem;
	public static Item vegemiteontoastItem;
	public static Item anchovyrawItem;
	public static Item bassrawItem;
	public static Item carprawItem;
	public static Item catfishrawItem;
	public static Item charrrawItem;
	public static Item clamrawItem;
	public static Item crabrawItem;
	public static Item crayfishrawItem;
	public static Item eelrawItem;
	public static Item frograwItem;
	public static Item grouperrawItem;
	public static Item herringrawItem;
	public static Item jellyfishrawItem;
	public static Item mudfishrawItem;
	public static Item octopusrawItem;
	public static Item perchrawItem;
	public static Item scalloprawItem;
	public static Item shrimprawItem;
	public static Item snailrawItem;
	public static Item snapperrawItem;
	public static Item tilapiarawItem;
	public static Item troutrawItem;
	public static Item tunarawItem;
	public static Item turtlerawItem;
	public static Item walleyerawItem;

	public static Item clamcookedItem;
	public static Item crabcookedItem;
	public static Item crayfishcookedItem;
	public static Item frogcookedItem;
	public static Item octopuscookedItem;
	public static Item scallopcookedItem;
	public static Item shrimpcookedItem;
	public static Item snailcookedItem;
	public static Item turtlecookedItem;
	public static Item appleciderItem;
	public static Item bangersandmashItem;
	public static Item batteredsausageItem;
	public static Item batterItem;
	public static Item chorizoItem;
	public static Item coleslawItem;
	public static Item energydrinkItem;
	public static Item friedonionsItem;
	public static Item meatfeastpizzaItem;
	public static Item mincepieItem;
	public static Item onionhamburgerItem;
	public static Item pepperoniItem;
	public static Item pickledonionsItem;
	public static Item porksausageItem;
	public static Item raspberrytrifleItem;

	public static Item pumpkinmuffinItem;
	public static Item suaderoItem;
	public static Item randomtacoItem;
	public static Item turkeyrawItem;
	public static Item turkeycookedItem;
	public static Item venisonrawItem;
	public static Item venisoncookedItem;
	public static Item strawberrymilkshakeItem;
	public static Item chocolatemilkshakeItem;
	public static Item bananamilkshakeItem;
	public static Item cornflakesItem;
	public static Item coleslawburgerItem;
	public static Item roastchickenItem;
	public static Item roastpotatoesItem;
	public static Item sundayroastItem;
	public static Item bbqpulledporkItem;
	public static Item lambwithmintsauceItem;
	public static Item steakandchipsItem;
	public static Item cherryicecreamItem;
	public static Item pistachioicecreamItem;
	public static Item neapolitanicecreamItem;
	public static Item spumoniicecreamItem;
	public static Item almondbutterItem;
	public static Item cashewbutterItem;
	public static Item chestnutbutterItem;
	public static Item cornishpastyItem;
	public static Item cottagepieItem;
	public static Item croissantItem;
	public static Item currypowderItem;
	public static Item dimsumItem;
	public static Item friedpecanokraItem;
	public static Item gooseberryjellyItem;
	public static Item gooseberryjellysandwichItem;
	public static Item gooseberrymilkshakeItem;
	public static Item gooseberrypieItem;
	public static Item gooseberrysmoothieItem;
	public static Item gooseberryyogurtItem;
	public static Item greenheartfishItem;
	public static Item hamsweetpicklesandwichItem;
	public static Item hushpuppiesItem;
	public static Item kimchiItem;
	public static Item mochiItem;
	public static Item museliItem;
	public static Item naanItem;
	public static Item okrachipsItem;
	public static Item okracreoleItem;
	public static Item pistachiobutterItem;
	public static Item ploughmanslunchItem;
	public static Item porklomeinItem;
	public static Item salmonpattiesItem;
	public static Item sausageItem;
	public static Item sausagerollItem;
	public static Item sesameballItem;
	public static Item sesamesnapsItem;
	public static Item shrimpokrahushpuppiesItem;
	public static Item soysauceItem;
	public static Item sweetpickleItem;
	public static Item veggiestripsItem;
	public static Item vindalooItem;

	public static Item applesmoothieItem;
	public static Item cheeseontoastItem;
	public static Item chocolaterollItem;
	public static Item coconutcreamItem;
	public static Item coconutsmoothieItem;
	public static Item crackerItem;
	public static Item cranberrysmoothieItem;
	public static Item cranberryyogurtItem;
	public static Item deluxechickencurryItem;
	public static Item garammasalaItem;
	public static Item grapesmoothieItem;
	public static Item gravyItem;
	public static Item honeysandwichItem;
	public static Item jamrollItem;
	public static Item mangochutneyItem;
	public static Item marzipanItem;
	public static Item paneerItem;
	public static Item paneertikkamasalaItem;
	public static Item peaandhamsoupItem;
	public static Item pearjellyItem;
	public static Item pearjellysandwichItem;
	public static Item pearsmoothieItem;
	public static Item plumjellyItem;
	public static Item plumjellysandwichItem;
	public static Item plumsmoothieItem;
	public static Item potatoandleeksoupItem;
	public static Item toadintheholeItem;
	public static Item tunapotatoItem;
	public static Item yorkshirepuddingItem;
	public static Item ediblerootItem;
	public static Item sunflowerseedsItem;
	public static Item sesameoilItem;
	public static Item hotandsoursoupItem;
	public static Item noodlesItem;
	public static Item chickenchowmeinItem;
	public static Item kungpaochickenItem;
	public static Item hoisinsauceItem;
	public static Item fivespiceItem;
	public static Item charsiuItem;
	public static Item sweetandsoursauceItem;
	public static Item sweetandsourchickenItem;
	public static Item baconandeggsItem;
	public static Item biscuitsandgravyItem;
	public static Item applefritterItem;
	public static Item sweetteaItem;
	public static Item creepercookieItem;
	public static Item patreonpieItem;

	public static Item honeybreadItem;
	public static Item honeybunItem;
	public static Item honeyglazedcarrotsItem;
	public static Item honeyglazedhamItem;
	public static Item honeysoyribsItem;
	
	
	public static Item anchovypepperonipizzaItem;
	public static Item chocovoxelsItem;
	public static Item cinnamontoastItem;
	public static Item cornedbeefhashItem;
	public static Item cornedbeefItem;
	public static Item cottoncandyItem;
	public static Item crackersItem;
	public static Item creeperwingsItem;
	public static Item dhalItem;
	public static Item durianmilkshakeItem;
	public static Item durianmuffinItem;
	public static Item homestylelunchItem;
	public static Item hotsauceItem;
	public static Item hummusItem;
	public static Item ironbrewItem;
	public static Item lasagnaItem;
	public static Item lemondrizzlecakeItem;
	public static Item meatloafItem;
	public static Item montecristosandwichItem;
	public static Item mushroomlasagnaItem;
	public static Item musselcookedItem;
	public static Item musselrawItem;
	public static Item netherwingsItem;
	public static Item pizzasoupItem;
	public static Item poutineItem;
	public static Item salsaItem;
	public static Item sardinerawItem;
	public static Item sardinesinhotsauceItem;
	public static Item teriyakichickenItem;
	public static Item toastedwesternItem;
	public static Item turkishdelightItem;

	public static Item cornedbeefbreakfastItem;
	public static Item greeneggsandhamItem;
	public static Item spaghettidinnerItem;
	public static Item theatreboxItem;
	public static Item cookiesandmilkItem;
	public static Item crackersandcheeseItem;
	public static Item chickendinnerItem;
	public static Item bbqplatterItem;
	public static Item weekendpicnicItem;
	public static Item corndogItem;
	public static Item chilidogItem;
	public static Item hamandcheesesandwichItem;
	public static Item tunafishsandwichItem;
	public static Item tunasaladItem;
	public static Item gritsItem;
	public static Item southernstylebreakfastItem;
	public static Item chimichangaItem;
	public static Item clamchowderItem;
	public static Item breakfastburritoItem;
	public static Item buttercookieItem;
	public static Item sugarcookieItem;
	public static Item potatochipsItem;
	public static Item bbqpotatochipsItem;
	public static Item sourcreamandonionpotatochipsItem;
	public static Item cheddarandsourcreampotatochipsItem;
	public static Item tortillachipsItem;
	public static Item chipsandsalsaItem;
	public static Item chipsanddipItem;
	public static Item cheezepuffsItem;
	public static Item surfandturfItem;
	public static Item liverandonionsItem;
	public static Item beefjerkyItem;
	public static Item fortunecookieItem;
	public static Item deviledeggItem;
	public static Item mozzerellasticksItem;
	public static Item gumboItem;
	public static Item jambalayaItem;
	public static Item succotashItem;
	public static Item eggsbenedictItem;
	public static Item friedgreentomatoesItem;
	public static Item chickenandwafflesItem;
	public static Item potatoesobrienItem;
	public static Item tatertotsItem;
	public static Item smoresItem;
	public static Item thankfuldinnerItem;
	public static Item steakfajitaItem;
	public static Item ramenItem;
	public static Item misosoupItem;
	public static Item onigiriItem;
	public static Item grilledcheesevegemitetoastItem;
	public static Item monsterfrieddumplingsItem;
	public static Item salisburysteakItem;
	public static Item crispyricepuffcerealItem;
	public static Item crispyricepuffbarsItem;
	public static Item babaganoushItem;
	public static Item berryvinaigrettesaladItem;
	public static Item tomatoherbchickenItem;
	public static Item pastagardeniaItem;
	public static Item fiestacornsaladItem;
	public static Item threebeansaladItem;
	public static Item sweetandsourmeatballsItem;
	public static Item pepperjellyItem;
	public static Item pepperjellyandcrackersItem;
	public static Item saltedcaramelItem;
	public static Item caramelicecreamItem;
	public static Item spidereyepieItem;
	public static Item cheesyshrimpquinoaItem;
	public static Item bulgogiItem;
	public static Item omuriceItem;
	public static Item koreandinnerItem;
	public static Item pemmicanItem;
	public static Item driedsoupItem;
	public static Item crabkimbapItem;
	public static Item froglegstirfryItem;
	public static Item crawfishetoufeeItem;
	public static Item haggisItem;
	public static Item chickenkatsuItem;
	public static Item chocolateorangeItem;
	public static Item festivalbreadItem;
	public static Item fruitcreamfestivalbreadItem;
	public static Item phoItem;
	public static Item bubbleteaItem;
	public static Item duckrawItem;
	public static Item duckcookedItem;
	public static Item wontonsoupItem;
	public static Item springrollItem;
	public static Item meatystirfryItem;
	public static Item potstickersItem;
	public static Item orangeduckItem;
	public static Item pekingduckItem;
	public static Item stuffedduckItem;
	public static Item rouxItem;
	
	public static Item candiedpecansItem;
	public static Item enchiladaItem;
	public static Item stuffingItem;
	public static Item greenbeancasseroleItem;
	public static Item hamandpineapplepizzaItem;
	public static Item saucedlambkebabItem;
	public static Item cobblestonecobblerItem;
	public static Item crayfishsaladItem;
	public static Item cevicheItem;
	public static Item deluxenachoesItem;
	public static Item bakedcactusItem;
	public static Item garlicsteakItem;
	public static Item mushroomsteakItem;
	public static Item hotdishcasseroleItem;
	public static Item sausagebeanmeltItem;
	public static Item mettbrotchenItem;
	
	public static Item porkrindsItem;
	public static Item cracklinsItem;
	
	public static Item chorusfruitsoupItem;
	//public static Item gigapickleItem;
	
	public static Item akutuqItem;
	public static Item cantonesegreensItem;
	public static Item cantonesenoodlesItem;
	public static Item dangoItem;
	public static Item earlgreyteaItem;
	public static Item eggrollItem;
	public static Item eggtartItem;
	public static Item greenteaItem;
	public static Item meesuaItem;
	public static Item oystercookedItem;
	public static Item oysterrawItem;
	public static Item oystersauceItem;
	public static Item springfieldcashewchickenItem;
	public static Item squidinkspaghettiItem;
	public static Item steaktartareItem;
	public static Item szechuaneggplantItem;
	public static Item takoyakiItem;
	
	public static Item groundbeefItem;
	public static Item groundchickenItem;
	public static Item groundduckItem;
	public static Item groundfishItem;
	public static Item groundmuttonItem;
	public static Item groundporkItem;
	public static Item groundrabbitItem;
	public static Item groundturkeyItem;
	public static Item groundvenisonItem;
	
	
	public static Item rawtofeakItem;
	public static Item rawtofaconItem;
	public static Item rawtofishItem;
	public static Item rawtofeegItem;
	public static Item rawtofuttonItem;
	public static Item rawtofickenItem;
	public static Item rawtofabbitItem;
	public static Item rawtofurkeyItem;
	public static Item rawtofenisonItem;
	public static Item rawtofuduckItem;

	public static Item cookedtofeakItem;
	public static Item cookedtofaconItem;
	public static Item cookedtofishItem;
	public static Item cookedtofeegItem;
	public static Item cookedtofuttonItem;
	public static Item cookedtofickenItem;
	public static Item cookedtofabbitItem;
	public static Item cookedtofurkeyItem;
	public static Item cookedtofenisonItem;
	public static Item cookedtofuduckItem;

	public static Item carrotcakeItem;
	public static Item cheesecakeItem;
	public static Item cherrycheesecakeItem;
	public static Item pineappleupsidedowncakeItem;
	public static Item chocolatesprinklecakeItem;
	public static Item redvelvetcakeItem;
	public static Item holidaycakeItem;
	public static Item pumpkincheesecakeItem;
	public static Item lamingtonItem;
	public static Item pavlovaItem;

	public static Item queenbeeItem;
	public static Item grubItem;
	public static Item cookedgrubItem;
	public static Item honeycombItem;
	public static Item waxcombItem;
	public static Item royaljellyItem;
	public static Item beeswaxItem;
	public static Item fruitbaitItem;
	public static Item grainbaitItem;
	public static Item veggiebaitItem;
	public static Item fishtrapbaitItem;

	public static Item hardenedleatherItem;
	public static Item hardenedleatherhelmItem;
	public static Item hardenedleatherchestItem;
	public static Item hardenedleatherleggingsItem;
	public static Item hardenedleatherbootsItem;

	public static ArmorMaterial armorHardenedLeather = EnumHelper.addArmorMaterial("HARDENEDLEATHER",
			"harvestcraft:hardenedleather", 15, new int[] {2, 6, 5, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);

	public static Item applejuiceItem;
	public static Item melonjuiceItem;
	public static Item carrotjuiceItem;
	public static Item strawberryjuiceItem;
	public static Item grapejuiceItem;
	public static Item blueberryjuiceItem;
	public static Item cherryjuiceItem;
	public static Item papayajuiceItem;
	public static Item starfruitjuiceItem;
	public static Item orangejuiceItem;
	public static Item peachjuiceItem;
	public static Item limejuiceItem;
	public static Item mangojuiceItem;
	public static Item pomegranatejuiceItem;
	public static Item blackberryjuiceItem;
	public static Item raspberryjuiceItem;
	public static Item kiwijuiceItem;
	public static Item cranberryjuiceItem;
	public static Item cactusfruitjuiceItem;
	public static Item plumjuiceItem;
	public static Item pearjuiceItem;
	public static Item apricotjuiceItem;
	public static Item figjuiceItem;
	public static Item grapefruitjuiceItem;
	public static Item persimmonjuiceItem;

	public static boolean initialized = false;

	public static void registerItems() {
		registerFoodItems();
		registerBeesItems();
		registerTools();
		registerFish();
		registerArmorItems();
		if (ConfigHandler.enablevanillafoodBalance){
			registerVanillaReplacementItems();
		}
		
		
		initialized = true;
	}

	private static void registerVanillaReplacementItems() {
		harvestappleItem = registerItemFood("minecraft:apple", config.cropfoodRestore, config.cropsaturationRestore);
		harvestwheatItem = registerItemFood("minecraft:wheat", config.cropfoodRestore, config.cropsaturationRestore);
		harvestpotatoItem = registerItemSeedFood("minecraft:potato", config.cropfoodRestore, config.cropsaturationRestore, Blocks.POTATOES, Blocks.FARMLAND);
		harvestcarrotItem = registerItemSeedFood("minecraft:carrot", config.cropfoodRestore, config.cropsaturationRestore, Blocks.CARROTS, Blocks.FARMLAND);
		harvestbeetItem = registerItemFood("minecraft:beetroot", config.cropfoodRestore, config.cropsaturationRestore);
		harvestmelonItem = registerItemFood("minecraft:melon", config.cropfoodRestore, config.cropsaturationRestore);
		harvestpumpkinItem = registerItemFood("harvestpumpkinitem", config.cropfoodRestore, config.cropsaturationRestore);
		
		
		
		harvestbeefItem = registerItemVanillaFood("minecraft:beef", 1, config.snacksaturation, true);
		harvestcookedbeefItem = registerItemVanillaFood("minecraft:cooked_beef", 2, config.snacksaturation, true);
		harvestchickenItem = registerItemVanillaFood("minecraft:chicken", 1, config.snacksaturation, true);
		harvestcookedchickenItem = registerItemVanillaFood("minecraft:cooked_chicken", 2, config.snacksaturation, true);
		harvestporkchopItem = registerItemVanillaFood("minecraft:porkchop", 1, config.snacksaturation, true);
		harvestcookedporkchopItem = registerItemVanillaFood("minecraft:cooked_porkchop", 2, config.snacksaturation, true);
		harvestrabbitItem = registerItemVanillaFood("minecraft:rabbit", 1, config.snacksaturation, true);
		harvestcookedrabbitItem = registerItemVanillaFood("minecraft:cooked_rabbit", 2, config.snacksaturation, true);
		harvestmuttonItem = registerItemVanillaFood("minecraft:mutton", 1, config.snacksaturation, true);
		harvestcookedmuttonItem = registerItemVanillaFood("minecraft:cooked_mutton", 2, config.snacksaturation, true);
		harvestfishItem = registerItemVanillaFood("minecraft:cod", 1, config.snacksaturation, false);
		harvestcookedfishedItem = registerItemVanillaFood("minecraft:cooked_cod", 2, config.snacksaturation, false);
		harvestsalmonItem = registerItemVanillaFood("minecraft:salmon", 1, config.snacksaturation, false);
		harvestcookedsalmonfishedItem = registerItemVanillaFood("minecraft:cooked_salmon", 2, config.snacksaturation, false);
		harvestclownfishItem = registerItemVanillaFood("minecraft:clownfish", 1, config.snacksaturation, false);
		harvestpufferfishItem = registerItemVanillaFood("minecraft:pufferfish", 1, config.snacksaturation, false);
		
		harvestmushroomstewItem = registerItemVanillaFood("minecraft:mushroom_stew", 2, config.mealsaturation, false);
		harvestbreadItem = registerItemVanillaFood("minecraft:bread", 3, config.mealsaturation, false);
		harvestcookieItem = registerItemVanillaFood("minecraft:cookie", 2, config.mealsaturation, false);
		harvestbakedpotatoItem = registerItemVanillaFood("minecraft:baked_potato", 2, config.mealsaturation, false);
		pumpkinpieItem = registerItemVanillaFood("minecraft:pumpkin_pie", 4, config.mealsaturation, false);
		rabbitstewItem = registerItemVanillaFood("minecraft:rabbit_stew", 6, config.mealsaturation, false);
		beetrootsoupItem = registerItemVanillaFood("minecraft:beetroot_soup", 9, config.mealsaturation, false);
	}
	private static void registerArmorItems() {
		hardenedleatherItem = registerGenericItem("hardenedleatheritem");
		hardenedleatherhelmItem = registerItemArmor("hardenedleatherhelmitem", EntityEquipmentSlot.HEAD);
		hardenedleatherchestItem = registerItemArmor("hardenedleatherchestitem", EntityEquipmentSlot.CHEST);
		hardenedleatherleggingsItem = registerItemArmor("hardenedleatherleggingsitem", EntityEquipmentSlot.LEGS);
		hardenedleatherbootsItem = registerItemArmor("hardenedleatherbootsitem", EntityEquipmentSlot.FEET);
	}

	private static void registerBeesItems() {
		queenbeeItem = registerItemPamBee("queenbeeitem");
		grubItem = registerGenericItem("grubitem");
		cookedgrubItem = registerItemFood("cookedgrubitem", 2, config.snacksaturation);
		honeycombItem = registerGenericItem("honeycombitem");
		honeyItem = registerItemFood("honeyitem", 2, config.snacksaturation);
		waxcombItem = registerGenericItem("waxcombitem");
		royaljellyItem = registerGenericItem("royaljellyitem");

		beeswaxItem = registerGenericItem("beeswaxitem");
		fruitbaitItem = registerGenericItem("fruitbaititem");
		grainbaitItem = registerGenericItem("grainbaititem");
		veggiebaitItem = registerGenericItem("veggiebaititem");
		fishtrapbaitItem = registerGenericItem("fishtrapbaititem");
	}

	private static void registerFoodItems() {
		
		garliccoinItem = registerGenericItem("garliccoinitem");
		
		ediblerootItem = registerItemFood("ediblerootitem", config.cropfoodRestore, config.cropsaturationRestore);
		sunflowerseedsItem =
				registerItemFood("sunflowerseedsitem", config.cropfoodRestore, config.cropsaturationRestore);

		calamarirawItem = registerItemFood("calamarirawitem", 1, config.snacksaturation);
		calamaricookedItem = registerItemFood("calamaricookeditem", 2, config.mealsaturation);

		saltItem = registerGenericItem("saltitem");
		wovencottonItem = registerGenericItem("wovencottonitem");
		freshwaterItem = registerGenericItem("freshwateritem");
		freshmilkItem = registerGenericItem("freshmilkitem");

		grilledasparagusItem = registerItemFood("grilledasparagusitem", 2, config.mealsaturation);
		bakedsweetpotatoItem = registerItemFood("bakedsweetpotatoitem", 2, config.mealsaturation);
		grilledeggplantItem = registerItemFood("grilledeggplantitem", 2, config.mealsaturation);
		toastItem = registerItemFood("toastitem", 4, config.mealsaturation);
		cheeseItem = registerItemFood("cheeseitem", 2, config.mealsaturation);
		icecreamItem = registerItemFood("icecreamitem", 3, config.mealsaturation);
		grilledcheeseItem = registerItemFood("grilledcheeseitem", 8, config.mealsaturation);
		applesauceItem = registerItemFood("applesauceitem", 2, config.mealsaturation);
		pumpkinbreadItem = registerItemFood("pumpkinbreaditem", 5, config.mealsaturation);
		caramelappleItem = registerItemFood("caramelappleitem", 3, config.mealsaturation);

		applepieItem = registerItemFood("applepieitem", 5, config.mealsaturation);

		teaItem = registerPotionFood("teaitem", 2, config.mealsaturation);
		coffeeItem = registerPotionFood("coffeeitem", 2, config.mealsaturation);
		popcornItem = registerItemFood("popcornitem", 2, config.mealsaturation);
		raisinsItem = registerItemFood("raisinsitem", 2, config.mealsaturation);
		ricecakeItem = registerItemFood("ricecakeitem", 2, config.mealsaturation);
		toastedcoconutItem = registerItemFood("toastedcoconutitem", 2, config.mealsaturation);
		roastedpumpkinseedsItem = registerItemFood("roastedpumpkinseedsitem", 1, config.mealsaturation);

		vanillaItem = registerGenericItem("vanillaitem");
		toastedsesameseedsItem = registerGenericItem("toastedsesameseedsitem");
		flourItem = registerGenericItem("flouritem");

		doughItem = registerGenericItem("doughitem");

		pastaItem = registerGenericItem("pastaitem");
		heavycreamItem = registerGenericItem("heavycreamitem");
		butterItem = registerGenericItem("butteritem");

		registerJuices();

		pumpkinsoupItem = registerItemFood("pumpkinsoupitem", 4, config.mealsaturation);
		melonsmoothieItem = registerPotionFood("melonsmoothieitem", 3, config.mealsaturation);

		carrotsoupItem = registerItemFood("carrotsoupitem", 4, config.mealsaturation);
		glazedcarrotsItem = registerItemFood("glazedcarrotsitem", 4, config.mealsaturation);
		butteredpotatoItem = registerItemFood("butteredpotatoitem", 4, config.mealsaturation);
		loadedbakedpotatoItem = registerItemFood("loadedbakedpotatoitem", 8, config.mealsaturation);
		mashedpotatoesItem = registerItemFood("mashedpotatoesitem", 5, config.mealsaturation);
		potatosaladItem = registerItemFood("potatosaladitem", 3, config.mealsaturation);
		potatosoupItem = registerItemFood("potatosoupitem", 4, config.mealsaturation);
		friesItem = registerItemFood("friesitem", 2, config.mealsaturation);
		grilledmushroomItem = registerItemFood("grilledmushroomitem", 2, config.mealsaturation);
		stuffedmushroomItem = registerItemFood("stuffedmushroomitem", 7, config.mealsaturation);
		chickensandwichItem = registerItemFood("chickensandwichitem", 6, config.mealsaturation);
		chickennoodlesoupItem = registerItemFood("chickennoodlesoupitem", 6, config.mealsaturation);
		chickenpotpieItem = registerItemFood("chickenpotpieitem", 7, config.mealsaturation);
		breadedporkchopItem = registerItemFood("breadedporkchopitem", 5, config.mealsaturation);
		hotdogItem = registerItemFood("hotdogitem", 5, config.mealsaturation);
		bakedhamItem = registerItemFood("bakedhamitem", 4, config.mealsaturation);
		hamburgerItem = registerItemFood("hamburgeritem", 6, config.mealsaturation);
		cheeseburgerItem = registerItemFood("cheeseburgeritem", 8, config.mealsaturation);
		
		potroastItem = registerItemFood("potroastitem", 6, config.mealsaturation);
		fishsandwichItem = registerItemFood("fishsandwichitem", 6, config.mealsaturation);
		fishsticksItem = registerItemFood("fishsticksitem", 5, config.mealsaturation);
		fishandchipsItem = registerItemFood("fishandchipsitem", 7, config.mealsaturation);
		mayoItem = registerGenericItem("mayoitem");
		friedeggItem = registerItemFood("friedeggitem", 3, config.mealsaturation);
		scrambledeggItem = registerItemFood("scrambledeggitem", 3, config.mealsaturation);
		boiledeggItem = registerItemFood("boiledeggitem", 3, config.mealsaturation);
		eggsaladItem = registerItemFood("eggsaladitem", 4, config.mealsaturation);

		caramelItem = registerItemFood("caramelitem", 1, config.mealsaturation);
		taffyItem = registerItemFood("taffyitem", 2, config.mealsaturation);
		spidereyesoupItem = registerItemFood("spidereyesoupitem", 4, config.mealsaturation);
		zombiejerkyItem = registerItemFood("zombiejerkyitem", 3, config.mealsaturation);
		cocoapowderItem = registerGenericItem("cocoapowderitem");
		chocolatebarItem = registerItemFood("chocolatebaritem", 1, config.mealsaturation);
		hotchocolateItem = registerPotionFood("hotchocolateitem", 2, config.mealsaturation);
		chocolateicecreamItem = registerItemFood("chocolateicecreamitem", 4, config.mealsaturation);
		vegetablesoupItem = registerItemFood("vegetablesoupitem", 5, config.mealsaturation);
		stockItem = registerItemFood("stockitem", 2, config.mealsaturation);
		fruitsaladItem = registerItemFood("fruitsaladitem", 2, config.mealsaturation);
		spagettiItem = registerItemFood("spagettiitem", 3, config.mealsaturation);
		spagettiandmeatballsItem = registerItemFood("spagettiandmeatballsitem", 5, config.mealsaturation);
		tomatosoupItem = registerItemFood("tomatosoupitem", 3, config.mealsaturation);
		ketchupItem = registerGenericItem("ketchupitem");
		chickenparmasanItem = registerItemFood("chickenparmasanitem", 5, config.mealsaturation);
		
		springsaladItem = registerItemFood("springsaladitem", 2, config.mealsaturation);
		porklettucewrapItem = registerItemFood("porklettucewrapitem", 3, config.mealsaturation);
		fishlettucewrapItem = registerItemFood("fishlettucewrapitem", 3, config.mealsaturation);
		bltItem = registerItemFood("bltitem", 8, config.mealsaturation);
		
		leafychickensandwichItem = registerItemFood("leafychickensandwichitem", 7, config.mealsaturation);
		leafyfishsandwichItem = registerItemFood("leafyfishsandwichitem", 7, config.mealsaturation);
		
		
		
		potatocakesItem = registerItemFood("potatocakesitem", 4, config.mealsaturation);
		hashItem = registerItemFood("hashitem", 5, config.mealsaturation);
		braisedonionsItem = registerItemFood("braisedonionsitem", 5, config.mealsaturation);
		
		cornonthecobItem = registerItemFood("cornonthecobitem", 3, config.mealsaturation);
		cornmealItem = registerGenericItem("cornmealitem");
		cornbreadItem = registerItemFood("cornbreaditem", 4, config.mealsaturation);
		tortillaItem = registerItemFood("tortillaitem", 3, config.mealsaturation);
		nachoesItem = registerItemFood("nachoesitem", 5, config.mealsaturation);
		tacoItem = registerItemFood("tacoitem", 8, config.mealsaturation);
		fishtacoItem = registerItemFood("fishtacoitem", 8, config.mealsaturation);
		creamedcornItem = registerItemFood("creamedcornitem", 3, config.mealsaturation);
		strawberrysmoothieItem = registerItemFood("strawberrysmoothieitem", 3, config.mealsaturation);
		strawberrypieItem = registerItemFood("strawberrypieitem", 5, config.mealsaturation);
		strawberrysaladItem = registerItemFood("strawberrysaladitem", 3, config.mealsaturation);
		chocolatestrawberryItem = registerItemFood("chocolatestrawberryitem", 2, config.mealsaturation);
		peanutbutterItem = registerItemFood("peanutbutteritem", 1, config.mealsaturation);
		trailmixItem = registerItemFood("trailmixitem", 4, config.mealsaturation);
		pbandjItem = registerItemFood("pbandjitem", 6, config.mealsaturation);
		peanutbuttercookiesItem = registerItemFood("peanutbuttercookiesitem", 5, config.mealsaturation);
		vinegarItem = registerGenericItem("vinegaritem");
		grapejellyItem = registerItemFood("grapejellyitem", 2, config.mealsaturation);
		grapesaladItem = registerItemFood("grapesaladitem", 3, config.mealsaturation);
		raisincookiesItem = registerItemFood("raisincookiesitem", 6, config.mealsaturation);
		picklesItem = registerItemFood("picklesitem", 4, config.mealsaturation);
		cucumbersaladItem = registerItemFood("cucumbersaladitem", 3, config.mealsaturation);
		cucumbersoupItem = registerItemFood("cucumbersoupitem", 4, config.mealsaturation);
		vegetarianlettucewrapItem = registerItemFood("vegetarianlettucewrapitem", 3, config.mealsaturation);
		marinatedcucumbersItem = registerItemFood("marinatedcucumbersitem", 5, config.mealsaturation);
		ricesoupItem = registerItemFood("ricesoupitem", 3, config.mealsaturation);
		friedriceItem = registerItemFood("friedriceitem", 5, config.mealsaturation);
		mushroomrisottoItem = registerItemFood("mushroomrisottoitem", 5, config.mealsaturation);
		curryItem = registerItemFood("curryitem", 6, config.mealsaturation);
		
		rainbowcurryItem = registerItemFood("rainbowcurryitem", 7, config.mealsaturation);
		refriedbeansItem = registerItemFood("refriedbeansitem", 4, config.mealsaturation);
		bakedbeansItem = registerItemFood("bakedbeansitem", 4, config.mealsaturation);
		beansandriceItem = registerItemFood("beansandriceitem", 5, config.mealsaturation);
		chiliItem = registerItemFood("chiliitem", 4, config.mealsaturation);
		beanburritoItem = registerItemFood("beanburritoitem", 7, config.mealsaturation);
		stuffedpepperItem = registerItemFood("stuffedpepperitem", 3, config.mealsaturation);
		veggiestirfryItem = registerItemFood("veggiestirfryitem", 5, config.mealsaturation);
		grilledskewersItem = registerItemFood("grilledskewersitem", 4, config.mealsaturation);
		
		omeletItem = registerItemFood("omeletitem", 4, config.mealsaturation);
		hotwingsItem = registerItemFood("hotwingsitem", 3, config.mealsaturation);
		chilipoppersItem = registerItemFood("chilipoppersitem", 6, config.mealsaturation);
		extremechiliItem = registerItemFood("extremechiliitem", 5, config.mealsaturation);
		chilichocolateItem = registerItemFood("chilichocolateitem", 2, config.mealsaturation);
		lemonaideItem = registerPotionFood("lemonaideitem", 3, config.mealsaturation);
		lemonbarItem = registerItemFood("lemonbaritem", 5, config.mealsaturation);
		fishdinnerItem = registerItemFood("fishdinneritem", 7, config.mealsaturation);
		lemonsmoothieItem = registerItemFood("lemonsmoothieitem", 3, config.mealsaturation);
		lemonmeringueItem = registerItemFood("lemonmeringueitem", 6, config.mealsaturation);
		candiedlemonItem = registerItemFood("candiedlemonitem", 2, config.mealsaturation);
		lemonchickenItem = registerItemFood("lemonchickenitem", 5, config.mealsaturation);
		blueberrysmoothieItem = registerPotionFood("blueberrysmoothieitem", 3, config.mealsaturation);
		blueberrypieItem = registerItemFood("blueberrypieitem", 5, config.mealsaturation);
		blueberrymuffinItem = registerItemFood("blueberrymuffinitem", 4, config.mealsaturation);
		pancakesItem = registerItemFood("pancakesitem", 4, config.mealsaturation);
		blueberrypancakesItem = registerItemFood("blueberrypancakesitem", 7, config.mealsaturation);
		cherrypieItem = registerItemFood("cherrypieitem", 5, config.mealsaturation);
		chocolatecherryItem = registerItemFood("chocolatecherryitem", 2, config.mealsaturation);
		cherrysmoothieItem = registerPotionFood("cherrysmoothieitem", 3, config.mealsaturation);

		stuffedeggplantItem = registerItemFood("stuffedeggplantitem", 7, config.mealsaturation);
		eggplantparmItem = registerItemFood("eggplantparmitem", 5, config.mealsaturation);
		raspberryicedteaItem = registerPotionFood("raspberryicedteaitem", 3, config.mealsaturation);
		chaiteaItem = registerPotionFood("chaiteaitem", 3, config.mealsaturation);
		espressoItem = registerPotionFood("espressoitem", 4, config.mealsaturation);
		coffeeconlecheItem = registerPotionFood("coffeeconlecheitem", 6, config.mealsaturation);
		mochaicecreamItem = registerItemFood("mochaicecreamitem", 5, config.mealsaturation);
		pickledbeetsItem = registerItemFood("pickledbeetsitem", 4, config.mealsaturation);
		beetsaladItem = registerItemFood("beetsaladitem", 6, config.mealsaturation);
		beetsoupItem = registerItemFood("beetsoupitem", 4, config.mealsaturation);
		bakedbeetsItem = registerItemFood("bakedbeetsitem", 4, config.mealsaturation);
		broccolimacItem = registerItemFood("broccolimacitem", 4, config.mealsaturation);
		broccolindipItem = registerItemFood("broccolindipitem", 3, config.mealsaturation);
		creamedbroccolisoupItem = registerItemFood("creamedbroccolisoupitem", 6, config.mealsaturation);
		sweetpotatopieItem = registerItemFood("sweetpotatopieitem", 9, config.mealsaturation);
		candiedsweetpotatoesItem = registerItemFood("candiedsweetpotatoesitem", 3, config.mealsaturation);
		mashedsweetpotatoesItem = registerItemFood("mashedsweetpotatoesitem", 3, config.mealsaturation);
		steamedpeasItem = registerItemFood("steamedpeasitem", 2, config.mealsaturation);
		splitpeasoupItem = registerItemFood("splitpeasoupitem", 6, config.mealsaturation);

		pineapplehamItem = registerItemFood("pineapplehamitem", 5, config.mealsaturation);
		pineappleyogurtItem = registerItemFood("pineappleyogurtitem", 2, config.mealsaturation);
		turnipsoupItem = registerItemFood("turnipsoupitem", 6, config.mealsaturation);
		roastedrootveggiemedleyItem = registerItemFood("roastedrootveggiemedleyitem", 4, config.mealsaturation);
		bakedturnipsItem = registerItemFood("bakedturnipsitem", 5, config.mealsaturation);
		gingerbreadItem = registerItemFood("gingerbreaditem", 7, config.mealsaturation);
		gingersnapsItem = registerItemFood("gingersnapsitem", 3, config.mealsaturation);
		candiedgingerItem = registerItemFood("candiedgingeritem", 2, config.mealsaturation);
		mustardItem = registerGenericItem("mustarditem");
		softpretzelandmustardItem = registerItemFood("softpretzelandmustarditem", 7, config.mealsaturation);
		spicymustardporkItem = registerItemFood("spicymustardporkitem", 4, config.mealsaturation);
		spicygreensItem = registerItemFood("spicygreensitem", 5, config.mealsaturation);
		garlicbreadItem = registerItemFood("garlicbreaditem", 7, config.mealsaturation);
		garlicmashedpotatoesItem = registerItemFood("garlicmashedpotatoesitem", 6, config.mealsaturation);
		garlicchickenItem = registerItemFood("garlicchickenitem", 6, config.mealsaturation);
		summerradishsaladItem = registerItemFood("summerradishsaladitem", 5, config.mealsaturation);
		summersquashwithradishItem = registerItemFood("summersquashwithradishitem", 5, config.mealsaturation);
		celeryandpeanutbutterItem = registerItemFood("celeryandpeanutbutteritem", 2, config.mealsaturation);
		chickencelerycasseroleItem = registerItemFood("chickencelerycasseroleitem", 6, config.mealsaturation);
		peasandceleryItem = registerItemFood("peasandceleryitem", 4, config.mealsaturation);
		celerysoupItem = registerItemFood("celerysoupitem", 5, config.mealsaturation);
		zucchinibreadItem = registerItemFood("zucchinibreaditem", 6, config.mealsaturation);
		zucchinifriesItem = registerItemFood("zucchinifriesitem", 9, config.mealsaturation);
		zestyzucchiniItem = registerItemFood("zestyzucchiniitem", 6, config.mealsaturation);
		zucchinibakeItem = registerItemFood("zucchinibakeitem", 9, config.mealsaturation);
		asparagusquicheItem = registerItemFood("asparagusquicheitem", 6, config.mealsaturation);
		asparagussoupItem = registerItemFood("asparagussoupitem", 6, config.mealsaturation);
		walnutraisinbreadItem = registerItemFood("walnutraisinbreaditem", 7, config.mealsaturation);
		candiedwalnutsItem = registerItemFood("candiedwalnutsitem", 4, config.mealsaturation);
		brownieItem = registerItemFood("brownieitem", 8, config.mealsaturation);
		papayasmoothieItem = registerPotionFood("papayasmoothieitem", 3, config.mealsaturation);
		papayayogurtItem = registerItemFood("papayayogurtitem", 2, config.mealsaturation);
		starfruitsmoothieItem = registerPotionFood("starfruitsmoothieitem", 3, config.mealsaturation);
		starfruityogurtItem = registerItemFood("starfruityogurtitem", 2, config.mealsaturation);
		guacamoleItem = registerItemFood("guacamoleitem", 5, config.mealsaturation);
		creamofavocadosoupItem = registerItemFood("creamofavocadosoupitem", 6, config.mealsaturation);
		avocadoburritoItem = registerItemFood("avocadoburritoitem", 8, config.mealsaturation);
		poachedpearItem = registerItemFood("poachedpearitem", 3, config.mealsaturation);
		fruitcrumbleItem = registerItemFood("fruitcrumbleitem", 5, config.mealsaturation);
		pearyogurtItem = registerItemFood("pearyogurtitem", 2, config.mealsaturation);
		plumyogurtItem = registerItemFood("plumyogurtitem", 2, config.mealsaturation);
		bananasplitItem = registerItemFood("bananasplititem", 7, config.mealsaturation);
		banananutbreadItem = registerItemFood("banananutbreaditem", 5, config.mealsaturation);
		bananasmoothieItem = registerPotionFood("bananasmoothieitem", 3, config.mealsaturation);
		bananayogurtItem = registerItemFood("bananayogurtitem", 2, config.mealsaturation);
		coconutmilkItem = registerPotionFood("coconutmilkitem", 1, config.mealsaturation);
		chickencurryItem = registerItemFood("chickencurryitem", 9, config.mealsaturation);
		coconutshrimpItem = registerItemFood("coconutshrimpitem", 7, config.mealsaturation);
		coconutyogurtItem = registerItemFood("coconutyogurtitem", 2, config.mealsaturation);
		orangechickenItem = registerItemFood("orangechickenitem", 6, config.mealsaturation);
		orangesmoothieItem = registerPotionFood("orangesmoothieitem", 3, config.mealsaturation);
		orangeyogurtItem = registerItemFood("orangeyogurtitem", 2, config.mealsaturation);
		peachcobblerItem = registerItemFood("peachcobbleritem", 5, config.mealsaturation);
		peachsmoothieItem = registerItemFood("peachsmoothieitem", 3, config.mealsaturation);
		peachyogurtItem = registerItemFood("peachyogurtitem", 2, config.mealsaturation);
		keylimepieItem = registerItemFood("keylimepieitem", 6, config.mealsaturation);
		limesmoothieItem = registerPotionFood("limesmoothieitem", 3, config.mealsaturation);
		limeyogurtItem = registerItemFood("limeyogurtitem", 2, config.mealsaturation);
		mangosmoothieItem = registerPotionFood("mangosmoothieitem", 3, config.mealsaturation);
		mangoyogurtItem = registerItemFood("mangoyogurtitem", 2, config.mealsaturation);
		pomegranatesmoothieItem = registerPotionFood("pomegranatesmoothieitem", 3, config.mealsaturation);
		pomegranateyogurtItem = registerItemFood("pomegranateyogurtitem", 2, config.mealsaturation);
		vanillayogurtItem = registerItemFood("vanillayogurtitem", 2, config.mealsaturation);
		cinnamonrollItem = registerItemFood("cinnamonrollitem", 5, config.mealsaturation);
		frenchtoastItem = registerItemFood("frenchtoastitem", 8, config.mealsaturation);
		marshmellowsItem = registerItemFood("marshmellowsitem", 4, config.mealsaturation);
		donutItem = registerItemFood("donutitem", 4, config.mealsaturation);
		chocolatedonutItem = registerItemFood("chocolatedonutitem", 5, config.mealsaturation);
		powdereddonutItem = registerItemFood("powdereddonutitem", 5, config.mealsaturation);
		jellydonutItem = registerItemFood("jellydonutitem", 6, config.mealsaturation);
		frosteddonutItem = registerItemFood("frosteddonutitem", 8, config.mealsaturation);
		cactussoupItem = registerItemFood("cactussoupitem", 3, config.mealsaturation);
		wafflesItem = registerItemFood("wafflesitem", 6, config.mealsaturation);
		seedsoupItem = registerItemFood("seedsoupitem", 3, config.mealsaturation);
		softpretzelItem = registerItemFood("softpretzelitem", 6, config.mealsaturation);
		jellybeansItem = registerItemFood("jellybeansitem", 3, config.mealsaturation);
		biscuitItem = registerItemFood("biscuititem", 5, config.mealsaturation);
		creamcookieItem = registerItemFood("creamcookieitem", 6, config.mealsaturation);
		jaffaItem = registerItemFood("jaffaitem", 6, config.mealsaturation);
		friedchickenItem = registerItemFood("friedchickenitem", 8, config.mealsaturation);

		footlongItem = registerItemFood("footlongitem", 8, config.mealsaturation);
		blueberryyogurtItem = registerItemFood("blueberryyogurtitem", 2, config.mealsaturation);
		lemonyogurtItem = registerItemFood("lemonyogurtitem", 2, config.mealsaturation);
		cherryyogurtItem = registerItemFood("cherryyogurtitem", 2, config.mealsaturation);
		strawberryyogurtItem = registerItemFood("strawberryyogurtitem", 2, config.mealsaturation);
		grapeyogurtItem = registerItemFood("grapeyogurtitem", 2, config.mealsaturation);
		chocolateyogurtItem = registerItemFood("chocolateyogurtitem", 2, config.mealsaturation);
		blackberrycobblerItem = registerItemFood("blackberrycobbleritem", 5, config.mealsaturation);
		blackberrysmoothieItem = registerPotionFood("blackberrysmoothieitem", 3, config.mealsaturation);
		blackberryyogurtItem = registerItemFood("blackberryyogurtitem", 2, config.mealsaturation);
		chocolatemilkItem = registerPotionFood("chocolatemilkitem", 2, config.mealsaturation);
		pumpkinyogurtItem = registerItemFood("pumpkinyogurtitem", 2, config.mealsaturation);
		raspberrypieItem = registerItemFood("raspberrypieitem", 5, config.mealsaturation);
		raspberrysmoothieItem = registerPotionFood("raspberrysmoothieitem", 3, config.mealsaturation);
		raspberryyogurtItem = registerItemFood("raspberryyogurtitem", 2, config.mealsaturation);
		cinnamonsugardonutItem = registerItemFood("cinnamonsugardonutitem", 7, config.mealsaturation);
		melonyogurtItem = registerItemFood("melonyogurtitem", 2, config.mealsaturation);
		kiwismoothieItem = registerPotionFood("kiwismoothieitem", 3, config.mealsaturation);
		kiwiyogurtItem = registerItemFood("kiwiyogurtitem", 2, config.mealsaturation);
		plainyogurtItem = registerItemFood("plainyogurtitem", 1, config.mealsaturation);
		appleyogurtItem = registerItemFood("appleyogurtitem", 2, config.mealsaturation);
		saltedsunflowerseedsItem = registerItemFood("saltedsunflowerseedsitem", 2, config.mealsaturation);
		sunflowerwheatrollsItem = registerItemFood("sunflowerwheatrollsitem", 6, config.mealsaturation);
		sunflowerbroccolisaladItem = registerItemFood("sunflowerbroccolisaladitem", 6, config.mealsaturation);
		cranberrysauceItem = registerItemFood("cranberrysauceitem", 2, config.mealsaturation);
		cranberrybarItem = registerItemFood("cranberrybaritem", 5, config.mealsaturation);
		peppermintItem = registerItemFood("peppermintitem", 2, config.mealsaturation);
		blackpepperItem = registerGenericItem("blackpepperitem");
		groundcinnamonItem = registerGenericItem("groundcinnamonitem");
		groundnutmegItem = registerGenericItem("groundnutmegitem");
		oliveoilItem = registerGenericItem("oliveoilitem");
		baklavaItem = registerItemFood("baklavaitem", 8, config.mealsaturation);
		gummybearsItem = registerItemFood("gummybearsitem", 3, config.mealsaturation);
		
		fruitpunchItem = registerPotionFood("fruitpunchitem", 2, config.mealsaturation);
		meatystewItem = registerItemFood("meatystewitem", 5, config.mealsaturation);
		mixedsaladItem = registerItemFood("mixedsaladitem", 6, config.mealsaturation);
		pinacoladaItem = registerItemFood("pinacoladaitem", 2, config.mealsaturation);
		saladdressingItem = registerGenericItem("saladdressingitem");
		shepardspieItem = registerItemFood("shepardspieitem", 8, config.mealsaturation);
		eggnogItem = registerPotionFood("eggnogitem", 5, config.mealsaturation);
		custardItem = registerItemFood("custarditem", 5, config.mealsaturation);
		sushiItem = registerItemFood("sushiitem", 4, config.mealsaturation);
		gardensoupItem = registerItemFood("gardensoupitem", 4, config.mealsaturation);
		applejellyItem = registerItemFood("applejellyitem", 2, config.mealsaturation);
		applejellysandwichItem = registerItemFood("applejellysandwichitem", 6, config.mealsaturation);
		blackberryjellyItem = registerItemFood("blackberryjellyitem", 2, config.mealsaturation);
		blackberryjellysandwichItem = registerItemFood("blackberryjellysandwichitem", 6, config.mealsaturation);
		blueberryjellyItem = registerItemFood("blueberryjellyitem", 2, config.mealsaturation);
		blueberryjellysandwichItem = registerItemFood("blueberryjellysandwichitem", 6, config.mealsaturation);
		cherryjellyItem = registerItemFood("cherryjellyitem", 2, config.mealsaturation);
		cherryjellysandwichItem = registerItemFood("cherryjellysandwichitem", 6, config.mealsaturation);
		cranberryjellyItem = registerItemFood("cranberryjellyitem", 2, config.mealsaturation);
		cranberryjellysandwichItem = registerItemFood("cranberryjellysandwichitem", 6, config.mealsaturation);
		kiwijellyItem = registerItemFood("kiwijellyitem", 2, config.mealsaturation);
		kiwijellysandwichItem = registerItemFood("kiwijellysandwichitem", 6, config.mealsaturation);
		lemonjellyItem = registerItemFood("lemonjellyitem", 2, config.mealsaturation);
		lemonjellysandwichItem = registerItemFood("lemonjellysandwichitem", 6, config.mealsaturation);
		limejellyItem = registerItemFood("limejellyitem", 2, config.mealsaturation);
		limejellysandwichItem = registerItemFood("limejellysandwichitem", 6, config.mealsaturation);
		mangojellyItem = registerItemFood("mangojellyitem", 2, config.mealsaturation);
		mangojellysandwichItem = registerItemFood("mangojellysandwichitem", 6, config.mealsaturation);
		orangejellyItem = registerItemFood("orangejellyitem", 2, config.mealsaturation);
		orangejellysandwichItem = registerItemFood("orangejellysandwichitem", 6, config.mealsaturation);
		papayajellyItem = registerItemFood("papayajellyitem", 2, config.mealsaturation);
		papayajellysandwichItem = registerItemFood("papayajellysandwichitem", 6, config.mealsaturation);
		peachjellyItem = registerItemFood("peachjellyitem", 2, config.mealsaturation);
		peachjellysandwichItem = registerItemFood("peachjellysandwichitem", 6, config.mealsaturation);
		pomegranatejellyItem = registerItemFood("pomegranatejellyitem", 2, config.mealsaturation);
		pomegranatejellysandwichItem = registerItemFood("pomegranatejellysandwichitem", 6, config.mealsaturation);
		raspberryjellyItem = registerItemFood("raspberryjellyitem", 2, config.mealsaturation);
		raspberryjellysandwichItem = registerItemFood("raspberryjellysandwichitem", 6, config.mealsaturation);
		starfruitjellyItem = registerItemFood("starfruitjellyitem", 2, config.mealsaturation);
		starfruitjellysandwichItem = registerItemFood("starfruitjellysandwichitem", 6, config.mealsaturation);
		strawberryjellyItem = registerItemFood("strawberryjellyitem", 2, config.mealsaturation);
		strawberryjellysandwichItem = registerItemFood("strawberryjellysandwichitem", 6, config.mealsaturation);
		watermelonjellyItem = registerItemFood("watermelonjellyitem", 2, config.mealsaturation);
		watermelonjellysandwichItem = registerItemFood("watermelonjellysandwichitem", 6, config.mealsaturation);
		bubblywaterItem = registerGenericItem("bubblywateritem");
		cherrysodaItem = registerPotionFood("cherrysodaitem", 3, config.mealsaturation);
		colasodaItem = registerPotionFood("colasodaitem", 3, config.mealsaturation);
		gingersodaItem = registerPotionFood("gingersodaitem", 3, config.mealsaturation);
		grapesodaItem = registerPotionFood("grapesodaitem", 4, config.mealsaturation);
		lemonlimesodaItem =
				registerPotionFood("lemonlimesodaitem", 5, config.mealsaturation);
		orangesodaItem = registerPotionFood("orangesodaitem", 4, config.mealsaturation);
		rootbeersodaItem =
				registerPotionFood("rootbeersodaitem", 3, config.mealsaturation);
		strawberrysodaItem =
				registerPotionFood("strawberrysodaitem", 4, config.mealsaturation);
		caramelicecreamItem = registerItemFood("caramelicecreamitem", 4, config.mealsaturation);
		mintchocolatechipicemcreamItem = registerItemFood("mintchocolatechipicecreamitem", 5, config.mealsaturation);
		strawberryicecreamItem = registerItemFood("strawberryicecreamitem", 4, config.mealsaturation);
		vanillaicecreamItem = registerItemFood("vanillaicecreamitem", 4, config.mealsaturation);
		gingerchickenItem = registerItemFood("gingerchickenitem", 6, config.mealsaturation);
		oldworldveggiesoupItem = registerItemFood("oldworldveggiesoupitem", 5, config.mealsaturation);
		spicebunItem = registerItemFood("spicebunitem", 6, config.mealsaturation);
		gingeredrhubarbtartItem = registerItemFood("gingeredrhubarbtartitem", 8, config.mealsaturation);
		lambbarleysoupItem = registerItemFood("lambbarleysoupitem", 7, config.mealsaturation);
		honeylemonlambItem = registerItemFood("honeylemonlambitem", 6, config.mealsaturation);
		pumpkinoatsconesItem = registerItemFood("pumpkinoatsconesitem", 5, config.mealsaturation);
		beefjerkyItem = registerItemFood("beefjerkyitem", 3, config.mealsaturation);
		ovenroastedcauliflowerItem = registerItemFood("ovenroastedcaulifloweritem", 4, config.mealsaturation);
		leekbaconsoupItem = registerItemFood("leekbaconsoupitem", 5, config.mealsaturation);
		herbbutterparsnipsItem = registerItemFood("herbbutterparsnipsitem", 4, config.mealsaturation);
		scallionbakedpotatoItem = registerItemFood("scallionbakedpotatoitem", 4, config.mealsaturation);
		soymilkItem = registerPotionFood("soymilkitem", 1, config.mealsaturation);
		firmtofuItem = registerItemFood("firmtofuitem", 2, config.mealsaturation);
		silkentofuItem = registerItemFood("silkentofuitem", 1, config.mealsaturation);
		bamboosteamedriceItem = registerItemFood("bamboosteamedriceitem", 2, config.mealsaturation);
		roastedchestnutItem = registerItemFood("roastedchestnutitem", 2, config.mealsaturation);
		sweetpotatosouffleItem = registerItemFood("sweetpotatosouffleitem", 7, config.mealsaturation);
		cashewchickenItem = registerItemFood("cashewchickenitem", 5, config.mealsaturation);
		apricotyogurtItem = registerItemFood("apricotyogurtitem", 2, config.mealsaturation);
		apricotglazedporkItem = registerItemFood("apricotglazedporkitem", 4, config.mealsaturation);
		apricotjellyItem = registerItemFood("apricotjellyitem", 2, config.mealsaturation);
		apricotjellysandwichItem = registerItemFood("apricotjellysandwichitem", 6, config.mealsaturation);
		apricotsmoothieItem = registerPotionFood("apricotsmoothieitem", 3, config.mealsaturation);
		figbarItem = registerItemFood("figbaritem", 5, config.mealsaturation);
		figjellyItem = registerItemFood("figjellyitem", 2, config.mealsaturation);
		figjellysandwichItem = registerItemFood("figjellysandwichitem", 6, config.mealsaturation);
		figsmoothieItem = registerPotionFood("figsmoothieitem", 3, config.mealsaturation);
		figyogurtItem = registerItemFood("figyogurtitem", 2, config.mealsaturation);
		grapefruitjellyItem = registerItemFood("grapefruitjellyitem", 2, config.mealsaturation);
		grapefruitjellysandwichItem = registerItemFood("grapefruitjellysandwichitem", 6, config.mealsaturation);
		grapefruitsmoothieItem = registerPotionFood("grapefruitsmoothieitem", 3, config.mealsaturation);
		grapefruityogurtItem = registerItemFood("grapefruityogurtitem", 2, config.mealsaturation);
		grapefruitsodaItem =
				registerPotionFood("grapefruitsodaitem", 4, config.mealsaturation).addDefaultSpeedPotionEffect();
		citrussaladItem = registerItemFood("citrussaladitem", 2, config.mealsaturation);
		pecanpieItem = registerItemFood("pecanpieitem", 7, config.mealsaturation);
		pralinesItem = registerItemFood("pralinesitem", 2, config.mealsaturation);
		persimmonyogurtItem = registerItemFood("persimmonyogurtitem", 2, config.mealsaturation);
		persimmonsmoothieItem = registerPotionFood("persimmonsmoothieitem", 3, config.mealsaturation);
		persimmonjellyItem = registerItemFood("persimmonjellyitem", 2, config.mealsaturation);
		persimmonjellysandwichItem = registerItemFood("persimmonjellysandwichitem", 6, config.mealsaturation);
		pistachiobakedsalmonItem = registerItemFood("pistachiobakedsalmonitem", 3, config.mealsaturation);
		baconwrappeddatesItem = registerItemFood("baconwrappeddatesitem", 3, config.mealsaturation);
		datenutbreadItem = registerItemFood("datenutbreaditem", 5, config.mealsaturation);
		maplesyruppancakesItem = registerItemFood("maplesyruppancakesitem", 7, config.mealsaturation);
		maplesyrupwafflesItem = registerItemFood("maplesyrupwafflesitem", 7, config.mealsaturation);
		maplesausageItem = registerItemFood("maplesausageitem", 4, config.mealsaturation);
		mapleoatmealItem = registerItemFood("mapleoatmealitem", 2, config.mealsaturation);
		peachesandcreamoatmealItem = registerItemFood("peachesandcreamoatmealitem", 3, config.mealsaturation);
		cinnamonappleoatmealItem = registerItemFood("cinnamonappleoatmealitem", 3, config.mealsaturation);
		maplecandiedbaconItem = registerItemFood("maplecandiedbaconitem", 3, config.mealsaturation);
		toastsandwichItem = registerItemFood("toastsandwichitem", 9, config.mealsaturation);
		potatoandcheesepirogiItem = registerItemFood("potatoandcheesepirogiitem", 6, config.mealsaturation);
		zeppoleItem = registerItemFood("zeppoleitem", 5, config.mealsaturation);
		sausageinbreadItem = registerItemFood("sausageinbreaditem", 9, config.mealsaturation);
		chocolatecaramelfudgeItem = registerItemFood("chocolatecaramelfudgeitem", 2, config.mealsaturation);
		lavendershortbreadItem = registerItemFood("lavendershortbreaditem", 4, config.mealsaturation);
		beefwellingtonItem = registerItemFood("beefwellingtonitem", 7, config.mealsaturation);
		epicbaconItem = registerItemFood("epicbaconitem", 9, config.mealsaturation);
		manjuuItem = registerItemFood("manjuuitem", 3, config.mealsaturation);
		chickengumboItem = registerItemFood("chickengumboitem", 9, config.mealsaturation);
		generaltsochickenItem = registerItemFood("generaltsochickenitem", 7, config.mealsaturation);
		californiarollItem = registerItemFood("californiarollitem", 6, config.mealsaturation);
		futomakiItem = registerItemFood("futomakiitem", 9, config.mealsaturation);
		
		vegemiteItem = registerItemFood("vegemiteitem", 4, config.mealsaturation);
		honeycombchocolatebarItem = registerItemFood("honeycombchocolatebaritem", 3, config.mealsaturation);
		cherrycoconutchocolatebarItem = registerItemFood("cherrycoconutchocolatebaritem", 4, config.mealsaturation);
		fairybreadItem = registerItemFood("fairybreaditem", 8, config.mealsaturation);

		timtamItem = registerItemFood("timtamitem", 4, config.mealsaturation);
		
		
		damperItem = registerItemFood("damperitem", 5, config.mealsaturation);
		

		gherkinItem = registerItemFood("gherkinitem", 5, config.mealsaturation);
		
		ceasarsaladItem = registerItemFood("ceasarsaladitem", 9, config.mealsaturation);
		chaoscookieItem = registerItemFood("chaoscookieitem", 3, config.mealsaturation);
		chocolatebaconItem = registerItemFood("chocolatebaconitem", 3, config.mealsaturation);
		lambkebabItem = registerItemFood("lambkebabitem", 5, config.mealsaturation);
		nutellaItem = registerItemFood("nutellaitem", 2, config.mealsaturation);
		snickersbarItem = registerItemFood("snickersbaritem", 3, config.mealsaturation);
		
		steamedspinachItem = registerItemFood("steamedspinachitem", 2, config.mealsaturation);
		vegemiteontoastItem = registerItemFood("vegemiteontoastitem", 5, config.mealsaturation);
		

		clamcookedItem = registerItemFood("clamcookeditem", 2, config.mealsaturation);
		crabcookedItem = registerItemFood("crabcookeditem", 2, config.mealsaturation);
		crayfishcookedItem = registerItemFood("crayfishcookeditem", 2, config.mealsaturation);
		frogcookedItem = registerItemFood("frogcookeditem", 2, config.mealsaturation);
		octopuscookedItem = registerItemFood("octopuscookeditem", 2, config.mealsaturation);
		scallopcookedItem = registerItemFood("scallopcookeditem", 2, config.mealsaturation);
		shrimpcookedItem = registerItemFood("shrimpcookeditem", 2, config.mealsaturation);
		snailcookedItem = registerItemFood("snailcookeditem", 2, config.mealsaturation);
		turtlecookedItem = registerItemFood("turtlecookeditem", 2, config.mealsaturation);
		oystercookedItem = registerItemFood("oystercookeditem", 2, config.mealsaturation);
		
		appleciderItem = registerItemFood("applecideritem", 2, config.mealsaturation);
		bangersandmashItem = registerItemFood("bangersandmashitem", 9, config.mealsaturation);
		batteredsausageItem = registerItemFood("batteredsausageitem", 7, config.mealsaturation);
		batterItem = registerGenericItem("batteritem");
		chorizoItem = registerItemFood("chorizoitem", 5, config.mealsaturation);
		coleslawItem = registerItemFood("coleslawitem", 4, config.mealsaturation);
		energydrinkItem =
				registerPotionFood("energydrinkitem", 5, config.mealsaturation).addDefaultSpeedPotionEffect();
		friedonionsItem = registerItemFood("friedonionsitem", 2, config.mealsaturation);
		
		mincepieItem = registerItemFood("mincepieitem", 9, config.mealsaturation);
		onionhamburgerItem = registerItemFood("onionhamburgeritem", 8, config.mealsaturation);
		pepperoniItem = registerItemFood("pepperoniitem", 5, config.mealsaturation);
		pickledonionsItem = registerItemFood("pickledonionsitem", 4, config.mealsaturation);
		porksausageItem = registerItemFood("porksausageitem", 4, config.mealsaturation);
		raspberrytrifleItem = registerItemFood("raspberrytrifleitem", 6, config.mealsaturation);

		pumpkinmuffinItem = registerItemFood("pumpkinmuffinitem", 4, config.mealsaturation);
		suaderoItem = registerItemFood("suaderoitem", 3, config.mealsaturation);
		
		turkeyrawItem = registerItemFood("turkeyrawitem", 1, config.mealsaturation);
		turkeycookedItem = registerItemFood("turkeycookeditem", 2, config.mealsaturation);
		venisonrawItem = registerItemFood("venisonrawitem", 1, config.mealsaturation);
		venisoncookedItem = registerItemFood("venisoncookeditem", 2, config.mealsaturation);
		strawberrymilkshakeItem = registerItemFood("strawberrymilkshakeitem", 3, config.mealsaturation);
		chocolatemilkshakeItem = registerItemFood("chocolatemilkshakeitem", 3, config.mealsaturation);
		bananamilkshakeItem = registerItemFood("bananamilkshakeitem", 3, config.mealsaturation);
		cornflakesItem = registerItemFood("cornflakesitem", 2, config.mealsaturation);
		
		roastchickenItem = registerItemFood("roastchickenitem", 4, config.mealsaturation);
		roastpotatoesItem = registerItemFood("roastpotatoesitem", 3, config.mealsaturation);
		sundayroastItem = registerItemFood("sundayroastitem", 8, config.mealsaturation);
		bbqpulledporkItem = registerItemFood("bbqpulledporkitem", 8, config.mealsaturation);
		lambwithmintsauceItem = registerItemFood("lambwithmintsauceitem", 6, config.mealsaturation);
		steakandchipsItem = registerItemFood("steakandchipsitem", 4, config.mealsaturation);
		cherryicecreamItem = registerItemFood("cherryicecreamitem", 4, config.mealsaturation);
		pistachioicecreamItem = registerItemFood("pistachioicecreamitem", 4, config.mealsaturation);
		neapolitanicecreamItem = registerItemFood("neapolitanicecreamitem", 4, config.mealsaturation);
		spumoniicecreamItem = registerItemFood("spumoniicecreamitem", 4, config.mealsaturation);
		almondbutterItem = registerItemFood("almondbutteritem", 1, config.mealsaturation);
		cashewbutterItem = registerItemFood("cashewbutteritem", 1, config.mealsaturation);
		chestnutbutterItem = registerItemFood("chestnutbutteritem", 1, config.mealsaturation);
		cornishpastyItem = registerItemFood("cornishpastyitem", 8, config.mealsaturation);
		cottagepieItem = registerItemFood("cottagepieitem", 8, config.mealsaturation);
		croissantItem = registerItemFood("croissantitem", 6, config.mealsaturation);
		currypowderItem = registerGenericItem("currypowderitem");
		dimsumItem = registerItemFood("dimsumitem", 8, config.mealsaturation);
		friedpecanokraItem = registerItemFood("friedpecanokraitem", 4, config.mealsaturation);
		gooseberryjellyItem = registerItemFood("gooseberryjellyitem", 2, config.mealsaturation);
		gooseberryjellysandwichItem = registerItemFood("gooseberryjellysandwichitem", 6, config.mealsaturation);
		gooseberrymilkshakeItem = registerItemFood("gooseberrymilkshakeitem", 3, config.mealsaturation);
		gooseberrypieItem = registerItemFood("gooseberrypieitem", 5, config.mealsaturation);
		gooseberrysmoothieItem = registerItemFood("gooseberrysmoothieitem", 3, config.mealsaturation);
		gooseberryyogurtItem = registerItemFood("gooseberryyogurtitem", 2, config.mealsaturation);
		
		hushpuppiesItem = registerItemFood("hushpuppiesitem", 5, config.mealsaturation);
		kimchiItem = registerItemFood("kimchiitem", 5, config.mealsaturation);
		mochiItem = registerItemFood("mochiitem", 3, config.mealsaturation);
		museliItem = registerItemFood("museliitem", 6, config.mealsaturation);
		
		naanItem = registerItemFood("naanitem", 5, config.mealsaturation);
		okrachipsItem = registerItemFood("okrachipsitem", 3, config.mealsaturation);
		okracreoleItem = registerItemFood("okracreoleitem", 6, config.mealsaturation);
		pistachiobutterItem = registerItemFood("pistachiobutteritem", 1, config.mealsaturation);
		
		porklomeinItem = registerItemFood("porklomeinitem", 9, config.mealsaturation);
		salmonpattiesItem = registerItemFood("salmonpattiesitem", 9, config.mealsaturation);
		sausageItem = registerItemFood("sausageitem", 4, config.mealsaturation);
		sausagerollItem = registerItemFood("sausagerollitem", 9, config.mealsaturation);
		sesameballItem = registerItemFood("sesameballitem", 5, config.mealsaturation);
		sesamesnapsItem = registerItemFood("sesamesnapsitem", 2, config.mealsaturation);
		shrimpokrahushpuppiesItem = registerItemFood("shrimpokrahushpuppiesitem", 8, config.mealsaturation);
		soysauceItem = registerGenericItem("soysauceitem");
		sweetpickleItem = registerItemFood("sweetpickleitem", 6, config.mealsaturation);
		veggiestripsItem = registerItemFood("veggiestripsitem", 5, config.mealsaturation);
		vindalooItem = registerItemFood("vindalooitem", 7, config.mealsaturation);
		applesmoothieItem = registerItemFood("applesmoothieitem", 3, config.mealsaturation);
		coconutsmoothieItem = registerItemFood("coconutsmoothieitem", 3, config.mealsaturation);
		cranberrysmoothieItem = registerItemFood("cranberrysmoothieitem", 3, config.mealsaturation);
		cranberryyogurtItem = registerItemFood("cranberryyogurtitem", 2, config.mealsaturation);
		grapesmoothieItem = registerItemFood("grapesmoothieitem", 3, config.mealsaturation);
		pearsmoothieItem = registerItemFood("pearsmoothieitem", 3, config.mealsaturation);
		pearjellyItem = registerItemFood("pearjellyitem", 2, config.mealsaturation);
		pearjellysandwichItem = registerItemFood("pearjellysandwichitem", 6, config.mealsaturation);
		plumsmoothieItem = registerItemFood("plumsmoothieitem", 3, config.mealsaturation);
		plumjellyItem = registerItemFood("plumjellyitem", 2, config.mealsaturation);
		plumjellysandwichItem = registerItemFood("plumjellysandwichitem", 6, config.mealsaturation);
		honeysandwichItem = registerItemFood("honeysandwichitem", 6, config.mealsaturation);
		cheeseontoastItem = registerItemFood("cheeseontoastitem", 6, config.mealsaturation);
		tunapotatoItem = registerItemFood("tunapotatoitem", 7, config.mealsaturation);
		chocolaterollItem = registerItemFood("chocolaterollitem", 3, config.mealsaturation);
		jamrollItem = registerItemFood("jamrollitem", 4, config.mealsaturation);
		coconutcreamItem = registerItemFood("coconutcreamitem", 2, config.mealsaturation);
		crackerItem = registerItemFood("crackeritem", 4, config.mealsaturation);
		garammasalaItem = registerGenericItem("garammasalaitem");
		paneerItem = registerItemFood("paneeritem", 1, config.mealsaturation);
		
		gravyItem = registerItemFood("gravyitem", 3, config.mealsaturation);
		mangochutneyItem = registerItemFood("mangochutneyitem", 4, config.mealsaturation);
		marzipanItem = registerItemFood("marzipanitem", 3, config.mealsaturation);
		paneertikkamasalaItem = registerItemFood("paneertikkamasalaitem", 9, config.mealsaturation);
		peaandhamsoupItem = registerItemFood("peaandhamsoupitem", 7, config.mealsaturation);
		potatoandleeksoupItem = registerItemFood("potatoandleeksoupitem", 7, config.mealsaturation);
		yorkshirepuddingItem = registerItemFood("yorkshirepuddingitem", 7, config.mealsaturation);
		

		sesameoilItem = registerGenericItem("sesameoilitem");
		
		noodlesItem = registerGenericItem("noodlesitem");
		chickenchowmeinItem = registerItemFood("chickenchowmeinitem", 8, config.mealsaturation);
		kungpaochickenItem = registerItemFood("kungpaochickenitem", 6, config.mealsaturation);
		hoisinsauceItem = registerGenericItem("hoisinsauceitem");
		fivespiceItem = registerGenericItem("fivespiceitem");
		charsiuItem = registerItemFood("charsiuitem", 8, config.mealsaturation);
		sweetandsoursauceItem = registerGenericItem("sweetandsoursauceitem");
		sweetandsourchickenItem = registerItemFood("sweetandsourchickenitem", 8, config.mealsaturation);
		baconandeggsItem = registerItemFood("baconandeggsitem", 4, config.mealsaturation);
		biscuitsandgravyItem = registerItemFood("biscuitsandgravyitem", 8, config.mealsaturation);
		applefritterItem = registerItemFood("applefritteritem", 6, config.mealsaturation);
		sweetteaItem = registerItemFood("sweetteaitem", 4, config.mealsaturation);
		creepercookieItem = registerItemFood("creepercookieitem", 5, config.mealsaturation);
		

		honeybreadItem = registerItemFood("honeybreaditem", 5, config.mealsaturation);
		honeybunItem = registerItemFood("honeybunitem", 9, config.mealsaturation);
		honeyglazedcarrotsItem = registerItemFood("honeyglazedcarrotsitem", 6, config.mealsaturation);
		honeyglazedhamItem = registerItemFood("honeyglazedhamitem", 5, config.mealsaturation);
		honeysoyribsItem = registerItemFood("honeysoyribsitem", 9, config.mealsaturation);

		
		
		chocovoxelsItem = registerItemFood("chocovoxelsitem", 2, config.mealsaturation);
		cinnamontoastItem = registerItemFood("cinnamontoastitem", 7, config.mealsaturation);
		
		cornedbeefItem = registerItemFood("cornedbeefitem", 9, config.mealsaturation);
		cottoncandyItem = registerItemFood("cottoncandyitem", 5, config.mealsaturation);
		crackersItem = registerItemFood("crackersitem", 6, config.mealsaturation);
		creeperwingsItem = registerItemFood("creeperwingsitem", 6, config.mealsaturation);
		dhalItem = registerItemFood("dhalitem", 7, config.mealsaturation);
		durianmilkshakeItem = registerItemFood("durianmilkshakeitem", 3, config.mealsaturation);
		durianmuffinItem = registerItemFood("durianmuffinitem", 4, config.mealsaturation);
		
		hotsauceItem = registerGenericItem("hotsauceitem");
		hummusItem = registerItemFood("hummusitem", 5, config.mealsaturation);
		ironbrewItem = registerItemFood("ironbrewitem", 9, config.mealsaturation);
		lasagnaItem = registerItemFood("lasagnaitem", 6, config.mealsaturation);
		lemondrizzlecakeItem = registerItemFood("lemondrizzlecakeitem", 7, config.mealsaturation);
		meatloafItem = registerItemFood("meatloafitem", 8, config.mealsaturation);
		
		mushroomlasagnaItem = registerItemFood("mushroomlasagnaitem", 7, config.mealsaturation);
		musselcookedItem = registerItemFood("musselcookeditem", 2, config.mealsaturation);
		netherwingsItem = registerItemFood("netherwingsitem", 9, config.mealsaturation);
		pizzasoupItem = registerItemFood("pizzasoupitem", 9, config.mealsaturation);
		poutineItem = registerItemFood("poutineitem", 7, config.mealsaturation);
		salsaItem = registerItemFood("salsaitem", 5, config.mealsaturation);
		sardinesinhotsauceItem = registerItemFood("sardinesinhotsauceitem", 3, config.mealsaturation);
		teriyakichickenItem = registerItemFood("teriyakichickenitem", 8, config.mealsaturation);
		
		turkishdelightItem = registerItemFood("turkishdelightitem", 5, config.mealsaturation);
		
		
		greeneggsandhamItem = registerItemFood("greeneggsandhamitem", 5, config.mealsaturation);
		
		theatreboxItem = registerItemFood("theatreboxitem", 7, config.mealsaturation);
		cookiesandmilkItem = registerItemFood("cookiesandmilkitem", 2, config.mealsaturation);
		crackersandcheeseItem = registerItemFood("crackersandcheeseitem", 8, config.mealsaturation);
		chickendinnerItem = registerItemFood("chickendinneritem", 9, config.mealsaturation);
		
		
		corndogItem = registerItemFood("corndogitem", 6, config.mealsaturation);
		
		hamandcheesesandwichItem = registerItemFood("hamandcheesesandwichitem", 7, config.mealsaturation);
		
		tunasaladItem = registerItemFood("tunasaladitem", 9, config.mealsaturation);
		gritsItem = registerItemFood("gritsitem", 4, config.mealsaturation);
		
		
		
		
		buttercookieItem = registerItemFood("buttercookieitem", 6, config.mealsaturation);
		sugarcookieItem = registerItemFood("sugarcookieitem", 7, config.mealsaturation);
		potatochipsItem = registerItemFood("potatochipsitem", 3, config.mealsaturation);
		bbqpotatochipsItem = registerItemFood("bbqpotatochipsitem", 7, config.mealsaturation);
		sourcreamandonionpotatochipsItem = registerItemFood("sourcreamandonionpotatochipsitem", 5, config.mealsaturation);
		cheddarandsourcreampotatochipsItem = registerItemFood("cheddarandsourcreampotatochipsitem", 6, config.mealsaturation);
		tortillachipsItem = registerItemFood("tortillachipsitem", 5, config.mealsaturation);
		
		chipsanddipItem = registerItemFood("chipsanddipitem", 5, config.mealsaturation);
		cheezepuffsItem = registerItemFood("cheezepuffsitem", 4, config.mealsaturation);
		surfandturfItem = registerItemFood("surfandturfitem", 5, config.mealsaturation);
		liverandonionsItem = registerItemFood("liverandonionsitem", 4, config.mealsaturation);
		fortunecookieItem = registerItemFood("fortunecookieitem", 5, config.mealsaturation);
		deviledeggItem = registerItemFood("deviledeggitem", 7, config.mealsaturation);
		mozzerellasticksItem = registerItemFood("mozzerellasticksitem", 6, config.mealsaturation);
		
		
		succotashItem = registerItemFood("succotashitem", 5, config.mealsaturation);
		
		friedgreentomatoesItem = registerItemFood("friedgreentomatoesitem", 5, config.mealsaturation);
		
		potatoesobrienItem = registerItemFood("potatoesobrienitem", 4, config.mealsaturation);
		tatertotsItem = registerItemFood("tatertotsitem", 3, config.mealsaturation);
		smoresItem = registerItemFood("smoresitem", 9, config.mealsaturation);
		
		steakfajitaItem = registerItemFood("steakfajitaitem", 9, config.mealsaturation);
		ramenItem = registerItemFood("ramenitem", 4, config.mealsaturation);
		misosoupItem = registerItemFood("misosoupitem", 3, config.mealsaturation);
		onigiriItem = registerItemFood("onigiriitem", 3, config.mealsaturation);
		grilledcheesevegemitetoastItem = registerItemFood("grilledcheesevegemitetoastitem", 9, config.mealsaturation);
		monsterfrieddumplingsItem = registerItemFood("monsterfrieddumplingsitem", 6, config.mealsaturation);
		
		crispyricepuffcerealItem = registerItemFood("crispyricepuffcerealitem", 2, config.mealsaturation);
		crispyricepuffbarsItem = registerItemFood("crispyricepuffbarsitem", 5, config.mealsaturation);
		babaganoushItem = registerItemFood("babaganoushitem", 5, config.mealsaturation);
		berryvinaigrettesaladItem = registerItemFood("berryvinaigrettesaladitem", 6, config.mealsaturation);
		tomatoherbchickenItem = registerItemFood("tomatoherbchickenitem", 4, config.mealsaturation);
		pastagardeniaItem = registerItemFood("pastagardeniaitem", 6, config.mealsaturation);
		fiestacornsaladItem = registerItemFood("fiestacornsaladitem", 7, config.mealsaturation);
		threebeansaladItem = registerItemFood("threebeansaladitem", 5, config.mealsaturation);
		sweetandsourmeatballsItem = registerItemFood("sweetandsourmeatballsitem", 6, config.mealsaturation);
		pepperjellyItem = registerItemFood("pepperjellyitem", 2, config.mealsaturation);
		pepperjellyandcrackersItem = registerItemFood("pepperjellyandcrackersitem", 8, config.mealsaturation);
		saltedcaramelItem = registerItemFood("saltedcaramelitem", 2, config.mealsaturation);
		spidereyepieItem = registerItemFood("spidereyepieitem", 6, config.mealsaturation);
		cheesyshrimpquinoaItem = registerItemFood("cheesyshrimpquinoaitem", 9, config.mealsaturation);
		bulgogiItem = registerItemFood("bulgogiitem", 7, config.mealsaturation);
		omuriceItem = registerItemFood("omuriceitem", 8, config.mealsaturation);
		
		pemmicanItem = registerItemFood("pemmicanitem", 6, config.mealsaturation);
		driedsoupItem = registerItemFood("driedsoupitem", 3, config.mealsaturation);
		crabkimbapItem = registerItemFood("crabkimbapitem", 6, config.mealsaturation);
		froglegstirfryItem = registerItemFood("froglegstirfryitem", 6, config.mealsaturation);
		
		haggisItem = registerItemFood("haggisitem", 6, config.mealsaturation);
		chickenkatsuItem = registerItemFood("chickenkatsuitem", 6, config.mealsaturation);
		chocolateorangeItem = registerItemFood("chocolateorangeitem", 2, config.mealsaturation);
		festivalbreadItem = registerItemFood("festivalbreaditem", 5, config.mealsaturation);
		fruitcreamfestivalbreadItem = registerItemFood("fruitcreamfestivalbreaditem", 7, config.mealsaturation);
		phoItem = registerItemFood("phoitem", 6, config.mealsaturation);
		bubbleteaItem = registerItemFood("bubbleteaitem", 4, config.mealsaturation);
		duckrawItem = registerItemFood("duckrawitem", 1, config.mealsaturation);
		duckcookedItem = registerItemFood("duckcookeditem", 2, config.mealsaturation);
		wontonsoupItem = registerItemFood("wontonsoupitem", 9, config.mealsaturation);
		springrollItem = registerItemFood("springrollitem", 7, config.mealsaturation);
		meatystirfryItem = registerItemFood("meatystirfryitem", 6, config.mealsaturation);
		potstickersItem = registerItemFood("potstickersitem", 7, config.mealsaturation);
		orangeduckItem = registerItemFood("orangeduckitem", 7, config.mealsaturation);
		pekingduckItem = registerItemFood("pekingduckitem", 7, config.mealsaturation);
		stuffedduckItem = registerItemFood("stuffedduckitem", 7, config.mealsaturation);
		rouxItem = registerGenericItem("rouxitem");

		candiedpecansItem = registerItemFood("candiedpecansitem", 3, config.mealsaturation);
		
		
		stuffingItem = registerItemFood("stuffingitem", 8, config.mealsaturation);
		greenbeancasseroleItem = registerItemFood("greenbeancasseroleitem", 6, config.mealsaturation);
		hamandpineapplepizzaItem = registerItemFood("hamandpineapplepizzaitem", 9, config.mealsaturation);
		
		cobblestonecobblerItem = registerItemFood("cobblestonecobbleritem", 6, config.mealsaturation);
		crayfishsaladItem = registerItemFood("crayfishsaladitem", 8, config.mealsaturation);
		cevicheItem = registerItemFood("cevicheitem", 7, config.mealsaturation);
		
		bakedcactusItem = registerItemFood("bakedcactusitem", 1, config.mealsaturation);
		garlicsteakItem = registerItemFood("garlicsteakitem", 6, config.mealsaturation);
		mushroomsteakItem = registerItemFood("mushroomsteakitem", 6, config.mealsaturation);
		hotdishcasseroleItem = registerItemFood("hotdishcasseroleitem", 9, config.mealsaturation);
		sausagebeanmeltItem = registerItemFood("sausagebeanmeltitem", 10, config.mealsaturation);
		mettbrotchenItem = registerItemFood("mettbrotchenitem", 8, config.mealsaturation);
		
		porkrindsItem = registerItemFood("porkrindsitem", 4, config.mealsaturation);
		cracklinsItem = registerItemFood("cracklinsitem", 5, config.mealsaturation);
		
		chorusfruitsoupItem = registerItemFood("chorusfruitsoupitem", 4, config.mealsaturation);
		//gigapickleItem = registerItemFood("gigapickleitem", 4, config.mealsaturation);
		
		akutuqItem = registerItemFood("akutuqitem", 5, config.mealsaturation);
		cantonesegreensItem = registerItemFood("cantonesegreensitem", 2, config.mealsaturation);
		
		earlgreyteaItem = registerItemFood("earlgreyteaitem", 2, config.mealsaturation);
		eggrollItem = registerItemFood("eggrollitem", 6, config.mealsaturation);
		eggtartItem = registerItemFood("eggtartitem", 8, config.mealsaturation);
		greenteaItem = registerItemFood("greenteaitem", 2, config.mealsaturation);
		meesuaItem = registerItemFood("meesuaitem", 8, config.mealsaturation);
		oystersauceItem = registerItemFood("oystersauceitem", 4, config.mealsaturation);
		squidinkspaghettiItem = registerItemFood("squidinkspaghettiitem", 2, config.mealsaturation);
		steaktartareItem = registerItemFood("steaktartareitem", 6, config.mealsaturation);
		szechuaneggplantItem = registerItemFood("szechuaneggplantitem", 9, config.mealsaturation);

		groundbeefItem = registerGenericItem("groundbeefitem");
		groundchickenItem = registerGenericItem("groundchickenitem");
		groundduckItem = registerGenericItem("groundduckitem");
		groundfishItem = registerGenericItem("groundfishitem");
		groundmuttonItem = registerGenericItem("groundmuttonitem");
		groundporkItem = registerGenericItem("groundporkitem");
		groundrabbitItem = registerGenericItem("groundrabbititem");
		groundturkeyItem = registerGenericItem("groundturkeyitem");
		groundvenisonItem = registerGenericItem("groundvenisonitem");
		
		rawtofeakItem = registerItemFood("rawtofeakitem", 1, config.snacksaturation);
		rawtofaconItem = registerItemFood("rawtofaconitem", 1, config.snacksaturation);
		//rawtofishItem = registerItemFood("rawtofishitem", 1, config.snacksaturation);
		rawtofeegItem = registerItemFood("rawtofeegitem", 1, config.snacksaturation);
		rawtofuttonItem = registerItemFood("rawtofuttonitem", 1, config.snacksaturation);
		rawtofickenItem = registerItemFood("rawtofickenitem", 1, config.snacksaturation);
		rawtofabbitItem = registerItemFood("rawtofabbititem", 1, config.snacksaturation);
		rawtofurkeyItem = registerItemFood("rawtofurkeyitem", 1, config.snacksaturation);
		rawtofenisonItem = registerItemFood("rawtofenisonitem", 1, config.snacksaturation);
		rawtofuduckItem = registerItemFood("rawtofuduckitem", 1, config.snacksaturation);

		cookedtofeakItem = registerItemFood("cookedtofeakitem", 2, config.mealsaturation);
		cookedtofaconItem = registerItemFood("cookedtofaconitem", 2, config.mealsaturation);
		cookedtofishItem = registerItemFood("cookedtofishitem", 2, config.mealsaturation);
		cookedtofeegItem = registerItemFood("cookedtofeegitem", 2, config.mealsaturation);
		cookedtofuttonItem = registerItemFood("cookedtofuttonitem", 2, config.mealsaturation);
		cookedtofickenItem = registerItemFood("cookedtofickenitem", 2, config.mealsaturation);
		cookedtofabbitItem = registerItemFood("cookedtofabbititem", 2, config.mealsaturation);
		cookedtofurkeyItem = registerItemFood("cookedtofurkeyitem", 2, config.mealsaturation);
		cookedtofenisonItem = registerItemFood("cookedtofenisonitem", 2, config.mealsaturation);
		cookedtofuduckItem = registerItemFood("cookedtofuduckitem", 2, config.snacksaturation);

		carrotcakeItem = registerItemPamCakeFood("carrotcakeitem", 5, config.mealsaturation, BlockRegistry.carrotcake);
		holidaycakeItem =
				registerItemPamCakeFood("holidaycakeitem", 6, config.mealsaturation, BlockRegistry.holidaycake);
		pumpkincheesecakeItem = registerItemPamCakeFood("pumpkincheesecakeitem", 6, config.mealsaturation,
				BlockRegistry.pumpkincheesecake);
		pavlovaItem = registerItemPamCakeFood("pavlovaitem", 6, config.mealsaturation, BlockRegistry.pavlovacake);
		lamingtonItem = registerItemPamCakeFood("lamingtonitem", 4, config.mealsaturation, BlockRegistry.lamingtoncake);
		cheesecakeItem = registerItemPamCakeFood("cheesecakeitem", 5, config.mealsaturation, BlockRegistry.cheesecake);
		cherrycheesecakeItem = registerItemPamCakeFood("cherrycheesecakeitem", 6, config.mealsaturation,
				BlockRegistry.cherrycheesecake);
		pineappleupsidedowncakeItem = registerItemPamCakeFood("pineappleupsidedowncakeitem", 6, config.mealsaturation,
				BlockRegistry.pineappleupsidedowncake);
		chocolatesprinklecakeItem = registerItemPamCakeFood("chocolatesprinklecakeitem", 8, config.mealsaturation,
				BlockRegistry.chocolatesprinklecake);
		redvelvetcakeItem =
				registerItemPamCakeFood("redvelvetcakeitem", 6, config.mealsaturation, BlockRegistry.redvelvetcake);
		
		if (ConfigHandler.topTierFood == 5)
		{
	//////////10 & 11 Food Points
								baconcheeseburgerItem = registerTopTierFood("baconcheeseburgeritem", 10, config.mealsaturation);
								deluxecheeseburgerItem = registerTopTierFood("deluxecheeseburgeritem", 10, config.mealsaturation);
								beansontoastItem = registerTopTierFood("beansontoastitem", 10, config.mealsaturation);
								meatpieItem = registerTopTierFood("meatpieitem", 10, config.mealsaturation);
								chikorollItem = registerTopTierFood("chikorollitem", 10, config.mealsaturation);
								spinachpieItem = registerTopTierFood("spinachpieitem", 10, config.mealsaturation);
								coleslawburgerItem = registerTopTierFood("coleslawburgeritem", 10, config.mealsaturation);
								hotandsoursoupItem = registerTopTierFood("hotandsoursoupitem", 10, config.mealsaturation);
								patreonpieItem = registerTopTierFood("patreonpieitem", 10, config.mealsaturation);
								chilidogItem = registerTopTierFood("chilidogitem", 10, config.mealsaturation);
								tunafishsandwichItem = registerTopTierFood("tunafishsandwichitem", 10, config.mealsaturation);
								clamchowderItem = registerTopTierFood("clamchowderitem", 10, config.mealsaturation);
								breakfastburritoItem = registerTopTierFood("breakfastburritoitem", 10, config.mealsaturation);
								chipsandsalsaItem = registerTopTierFood("chipsandsalsaitem", 10, config.mealsaturation);
								crawfishetoufeeItem = registerTopTierFood("crawfishetoufeeitem", 10, config.mealsaturation);
								saucedlambkebabItem = registerTopTierFood("saucedlambkebabitem", 10, config.mealsaturation);
								cantonesenoodlesItem = registerTopTierFood("cantonesenoodlesitem", 10, config.mealsaturation);
								dangoItem = registerTopTierFood("dangoitem", 10, config.mealsaturation);
								takoyakiItem = registerTopTierFood("takoyakiitem", 10, config.mealsaturation);
								
								springfieldcashewchickenItem = registerTopTierFood("springfieldcashewchickenitem", 11, config.mealsaturation);
								enchiladaItem = registerTopTierFood("enchiladaitem", 11, config.mealsaturation);
								pizzaItem = registerTopTierFood("pizzaitem", 11, config.mealsaturation);
								onionsoupItem = registerTopTierFood("onionsoupitem", 11, config.mealsaturation);
								baconmushroomburgerItem = registerTopTierFood("baconmushroomburgeritem", 11, config.mealsaturation);
								toadintheholeItem = registerTopTierFood("toadintheholeitem", 11, config.mealsaturation);
								homestylelunchItem = registerTopTierFood("homestylelunchitem", 11, config.mealsaturation);
								montecristosandwichItem = registerTopTierFood("montecristosandwichitem", 11, config.mealsaturation);

								//////////12 & 13 Food Points
								randomtacoItem = registerTopTierFood("randomtacoitem", 12, config.mealsaturation);
								hamsweetpicklesandwichItem = registerTopTierFood("hamsweetpicklesandwichitem", 12, config.mealsaturation);
								toastedwesternItem = registerTopTierFood("toastedwesternitem", 12, config.mealsaturation);
								eggsbenedictItem = registerTopTierFood("eggsbenedictitem", 12, config.mealsaturation);

								beetburgerItem = registerTopTierFood("beetburgeritem", 13, config.mealsaturation);
								anchovypepperonipizzaItem = registerTopTierFood("anchovypepperonipizzaitem", 13, config.mealsaturation);
								spaghettidinnerItem = registerTopTierFood("spaghettidinneritem", 13, config.mealsaturation);
								gumboItem = registerTopTierFood("gumboitem", 13, config.mealsaturation);
								jambalayaItem = registerTopTierFood("jambalayaitem", 13, config.mealsaturation);

								//////////14 & 15 Food Points
								supremepizzaItem = registerTopTierFood("supremepizzaitem", 14, config.mealsaturation);
								bbqplatterItem = registerTopTierFood("bbqplatteritem", 14, config.mealsaturation);
								chickenandwafflesItem = registerTopTierFood("chickenandwafflesitem", 14, config.mealsaturation);

								delightedmealItem = registerTopTierFood("delightedmealitem", 15, config.mealsaturation);
								heartybreakfastItem = registerTopTierFood("heartybreakfastitem", 15, config.mealsaturation);

								//////////16 & 17 Food Points
								mcpamItem = registerTopTierFood("mcpamitem", 16, config.mealsaturation);
								deluxenachoesItem = registerTopTierFood("deluxenachoesitem", 16, config.mealsaturation);
								
								chimichangaItem = registerTopTierFood("chimichangaitem", 17, config.mealsaturation);
								salisburysteakItem = registerTopTierFood("salisburysteakitem", 17, config.mealsaturation);

								//////////18 & 19 Food Points
								ploughmanslunchItem = registerTopTierFood("ploughmanslunchitem", 18, config.mealsaturation);
								cornedbeefhashItem = registerTopTierFood("cornedbeefhashitem", 18, config.mealsaturation);

								deluxechickencurryItem = registerTopTierFood("deluxechickencurryitem", 19, config.mealsaturation);
								weekendpicnicItem = registerTopTierFood("weekendpicnicitem", 19, config.mealsaturation);

								//////////20+ Food Points
								southernstylebreakfastItem = registerTopTierFood("southernstylebreakfastitem", 20, config.mealsaturation);

								meatfeastpizzaItem = registerTopTierFood("meatfeastpizzaitem", 24, config.mealsaturation);
								thankfuldinnerItem = registerTopTierFood("thankfuldinneritem", 24, config.mealsaturation);
								koreandinnerItem = registerTopTierFood("koreandinneritem", 24, config.mealsaturation);

								cornedbeefbreakfastItem = registerTopTierFood("cornedbeefbreakfastitem", 26, config.mealsaturation);			
		}
		
		if (ConfigHandler.topTierFood == 6)
		{
							//////////10 & 11 Food Points
							baconcheeseburgerItem = registerItemFood("baconcheeseburgeritem", 10, config.mealsaturation);
							deluxecheeseburgerItem = registerItemFood("deluxecheeseburgeritem", 10, config.mealsaturation);
							beansontoastItem = registerItemFood("beansontoastitem", 10, config.mealsaturation);
							meatpieItem = registerItemFood("meatpieitem", 10, config.mealsaturation);
							chikorollItem = registerItemFood("chikorollitem", 10, config.mealsaturation);
							spinachpieItem = registerItemFood("spinachpieitem", 10, config.mealsaturation);
							coleslawburgerItem = registerItemFood("coleslawburgeritem", 10, config.mealsaturation);
							hotandsoursoupItem = registerItemFood("hotandsoursoupitem", 10, config.mealsaturation);
							patreonpieItem = registerItemFood("patreonpieitem", 10, config.mealsaturation);
							chilidogItem = registerItemFood("chilidogitem", 10, config.mealsaturation);
							tunafishsandwichItem = registerItemFood("tunafishsandwichitem", 10, config.mealsaturation);
							clamchowderItem = registerItemFood("clamchowderitem", 10, config.mealsaturation);
							breakfastburritoItem = registerItemFood("breakfastburritoitem", 10, config.mealsaturation);
							chipsandsalsaItem = registerItemFood("chipsandsalsaitem", 10, config.mealsaturation);
							crawfishetoufeeItem = registerItemFood("crawfishetoufeeitem", 10, config.mealsaturation);
							saucedlambkebabItem = registerItemFood("saucedlambkebabitem", 10, config.mealsaturation);
							cantonesenoodlesItem = registerItemFood("cantonesenoodlesitem", 10, config.mealsaturation);
							dangoItem = registerItemFood("dangoitem", 10, config.mealsaturation);
							takoyakiItem = registerItemFood("takoyakiitem", 10, config.mealsaturation);
							
							springfieldcashewchickenItem = registerItemFood("springfieldcashewchickenitem", 11, config.mealsaturation);
							enchiladaItem = registerItemFood("enchiladaitem", 11, config.mealsaturation);
							pizzaItem = registerItemFood("pizzaitem", 11, config.mealsaturation);
							onionsoupItem = registerItemFood("onionsoupitem", 11, config.mealsaturation);
							baconmushroomburgerItem = registerItemFood("baconmushroomburgeritem", 11, config.mealsaturation);
							toadintheholeItem = registerItemFood("toadintheholeitem", 11, config.mealsaturation);
							homestylelunchItem = registerItemFood("homestylelunchitem", 11, config.mealsaturation);
							montecristosandwichItem = registerItemFood("montecristosandwichitem", 11, config.mealsaturation);

							//////////12 & 13 Food Points
							randomtacoItem = registerTopTierFood("randomtacoitem", 12, config.mealsaturation);
							hamsweetpicklesandwichItem = registerTopTierFood("hamsweetpicklesandwichitem", 12, config.mealsaturation);
							toastedwesternItem = registerTopTierFood("toastedwesternitem", 12, config.mealsaturation);
							eggsbenedictItem = registerTopTierFood("eggsbenedictitem", 12, config.mealsaturation);

							beetburgerItem = registerTopTierFood("beetburgeritem", 13, config.mealsaturation);
							anchovypepperonipizzaItem = registerTopTierFood("anchovypepperonipizzaitem", 13, config.mealsaturation);
							spaghettidinnerItem = registerTopTierFood("spaghettidinneritem", 13, config.mealsaturation);
							gumboItem = registerTopTierFood("gumboitem", 13, config.mealsaturation);
							jambalayaItem = registerTopTierFood("jambalayaitem", 13, config.mealsaturation);

							//////////14 & 15 Food Points
							supremepizzaItem = registerTopTierFood("supremepizzaitem", 14, config.mealsaturation);
							bbqplatterItem = registerTopTierFood("bbqplatteritem", 14, config.mealsaturation);
							chickenandwafflesItem = registerTopTierFood("chickenandwafflesitem", 14, config.mealsaturation);

							delightedmealItem = registerTopTierFood("delightedmealitem", 15, config.mealsaturation);
							heartybreakfastItem = registerTopTierFood("heartybreakfastitem", 15, config.mealsaturation);

							//////////16 & 17 Food Points
							mcpamItem = registerTopTierFood("mcpamitem", 16, config.mealsaturation);
							deluxenachoesItem = registerTopTierFood("deluxenachoesitem", 16, config.mealsaturation);
							
							chimichangaItem = registerTopTierFood("chimichangaitem", 17, config.mealsaturation);
							salisburysteakItem = registerTopTierFood("salisburysteakitem", 17, config.mealsaturation);

							//////////18 & 19 Food Points
							ploughmanslunchItem = registerTopTierFood("ploughmanslunchitem", 18, config.mealsaturation);
							cornedbeefhashItem = registerTopTierFood("cornedbeefhashitem", 18, config.mealsaturation);

							deluxechickencurryItem = registerTopTierFood("deluxechickencurryitem", 19, config.mealsaturation);
							weekendpicnicItem = registerTopTierFood("weekendpicnicitem", 19, config.mealsaturation);

							//////////20+ Food Points
							southernstylebreakfastItem = registerTopTierFood("southernstylebreakfastitem", 20, config.mealsaturation);

							meatfeastpizzaItem = registerTopTierFood("meatfeastpizzaitem", 24, config.mealsaturation);
							thankfuldinnerItem = registerTopTierFood("thankfuldinneritem", 24, config.mealsaturation);
							koreandinnerItem = registerTopTierFood("koreandinneritem", 24, config.mealsaturation);

							cornedbeefbreakfastItem = registerTopTierFood("cornedbeefbreakfastitem", 26, config.mealsaturation);	
		}
		
		if (ConfigHandler.topTierFood == 7)
		{
						//////////10 & 11 Food Points
						baconcheeseburgerItem = registerItemFood("baconcheeseburgeritem", 10, config.mealsaturation);
						deluxecheeseburgerItem = registerItemFood("deluxecheeseburgeritem", 10, config.mealsaturation);
						beansontoastItem = registerItemFood("beansontoastitem", 10, config.mealsaturation);
						meatpieItem = registerItemFood("meatpieitem", 10, config.mealsaturation);
						chikorollItem = registerItemFood("chikorollitem", 10, config.mealsaturation);
						spinachpieItem = registerItemFood("spinachpieitem", 10, config.mealsaturation);
						coleslawburgerItem = registerItemFood("coleslawburgeritem", 10, config.mealsaturation);
						hotandsoursoupItem = registerItemFood("hotandsoursoupitem", 10, config.mealsaturation);
						patreonpieItem = registerItemFood("patreonpieitem", 10, config.mealsaturation);
						chilidogItem = registerItemFood("chilidogitem", 10, config.mealsaturation);
						tunafishsandwichItem = registerItemFood("tunafishsandwichitem", 10, config.mealsaturation);
						clamchowderItem = registerItemFood("clamchowderitem", 10, config.mealsaturation);
						breakfastburritoItem = registerItemFood("breakfastburritoitem", 10, config.mealsaturation);
						chipsandsalsaItem = registerItemFood("chipsandsalsaitem", 10, config.mealsaturation);
						crawfishetoufeeItem = registerItemFood("crawfishetoufeeitem", 10, config.mealsaturation);
						saucedlambkebabItem = registerItemFood("saucedlambkebabitem", 10, config.mealsaturation);
						cantonesenoodlesItem = registerItemFood("cantonesenoodlesitem", 10, config.mealsaturation);
						dangoItem = registerItemFood("dangoitem", 10, config.mealsaturation);
						takoyakiItem = registerItemFood("takoyakiitem", 10, config.mealsaturation);
						
						springfieldcashewchickenItem = registerItemFood("springfieldcashewchickenitem", 11, config.mealsaturation);
						enchiladaItem = registerItemFood("enchiladaitem", 11, config.mealsaturation);
						pizzaItem = registerItemFood("pizzaitem", 11, config.mealsaturation);
						onionsoupItem = registerItemFood("onionsoupitem", 11, config.mealsaturation);
						baconmushroomburgerItem = registerItemFood("baconmushroomburgeritem", 11, config.mealsaturation);
						toadintheholeItem = registerItemFood("toadintheholeitem", 11, config.mealsaturation);
						homestylelunchItem = registerItemFood("homestylelunchitem", 11, config.mealsaturation);
						montecristosandwichItem = registerItemFood("montecristosandwichitem", 11, config.mealsaturation);

						//////////12 & 13 Food Points
						randomtacoItem = registerItemFood("randomtacoitem", 12, config.mealsaturation);
						hamsweetpicklesandwichItem = registerItemFood("hamsweetpicklesandwichitem", 12, config.mealsaturation);
						toastedwesternItem = registerItemFood("toastedwesternitem", 12, config.mealsaturation);
						eggsbenedictItem = registerItemFood("eggsbenedictitem", 12, config.mealsaturation);

						beetburgerItem = registerItemFood("beetburgeritem", 13, config.mealsaturation);
						anchovypepperonipizzaItem = registerItemFood("anchovypepperonipizzaitem", 13, config.mealsaturation);
						spaghettidinnerItem = registerItemFood("spaghettidinneritem", 13, config.mealsaturation);
						gumboItem = registerItemFood("gumboitem", 13, config.mealsaturation);
						jambalayaItem = registerItemFood("jambalayaitem", 13, config.mealsaturation);

						//////////14 & 15 Food Points
						supremepizzaItem = registerTopTierFood("supremepizzaitem", 14, config.mealsaturation);
						bbqplatterItem = registerTopTierFood("bbqplatteritem", 14, config.mealsaturation);
						chickenandwafflesItem = registerTopTierFood("chickenandwafflesitem", 14, config.mealsaturation);

						delightedmealItem = registerTopTierFood("delightedmealitem", 15, config.mealsaturation);
						heartybreakfastItem = registerTopTierFood("heartybreakfastitem", 15, config.mealsaturation);

						//////////16 & 17 Food Points
						mcpamItem = registerTopTierFood("mcpamitem", 16, config.mealsaturation);
						deluxenachoesItem = registerTopTierFood("deluxenachoesitem", 16, config.mealsaturation);
						
						chimichangaItem = registerTopTierFood("chimichangaitem", 17, config.mealsaturation);
						salisburysteakItem = registerTopTierFood("salisburysteakitem", 17, config.mealsaturation);

						//////////18 & 19 Food Points
						ploughmanslunchItem = registerTopTierFood("ploughmanslunchitem", 18, config.mealsaturation);
						cornedbeefhashItem = registerTopTierFood("cornedbeefhashitem", 18, config.mealsaturation);

						deluxechickencurryItem = registerTopTierFood("deluxechickencurryitem", 19, config.mealsaturation);
						weekendpicnicItem = registerTopTierFood("weekendpicnicitem", 19, config.mealsaturation);

						//////////20+ Food Points
						southernstylebreakfastItem = registerTopTierFood("southernstylebreakfastitem", 20, config.mealsaturation);

						meatfeastpizzaItem = registerTopTierFood("meatfeastpizzaitem", 24, config.mealsaturation);
						thankfuldinnerItem = registerTopTierFood("thankfuldinneritem", 24, config.mealsaturation);
						koreandinnerItem = registerTopTierFood("koreandinneritem", 24, config.mealsaturation);

						cornedbeefbreakfastItem = registerTopTierFood("cornedbeefbreakfastitem", 26, config.mealsaturation);			
		}
		
		if (ConfigHandler.topTierFood == 8)
		{
					//////////10 & 11 Food Points
					baconcheeseburgerItem = registerItemFood("baconcheeseburgeritem", 10, config.mealsaturation);
					deluxecheeseburgerItem = registerItemFood("deluxecheeseburgeritem", 10, config.mealsaturation);
					beansontoastItem = registerItemFood("beansontoastitem", 10, config.mealsaturation);
					meatpieItem = registerItemFood("meatpieitem", 10, config.mealsaturation);
					chikorollItem = registerItemFood("chikorollitem", 10, config.mealsaturation);
					spinachpieItem = registerItemFood("spinachpieitem", 10, config.mealsaturation);
					coleslawburgerItem = registerItemFood("coleslawburgeritem", 10, config.mealsaturation);
					hotandsoursoupItem = registerItemFood("hotandsoursoupitem", 10, config.mealsaturation);
					patreonpieItem = registerItemFood("patreonpieitem", 10, config.mealsaturation);
					chilidogItem = registerItemFood("chilidogitem", 10, config.mealsaturation);
					tunafishsandwichItem = registerItemFood("tunafishsandwichitem", 10, config.mealsaturation);
					clamchowderItem = registerItemFood("clamchowderitem", 10, config.mealsaturation);
					breakfastburritoItem = registerItemFood("breakfastburritoitem", 10, config.mealsaturation);
					chipsandsalsaItem = registerItemFood("chipsandsalsaitem", 10, config.mealsaturation);
					crawfishetoufeeItem = registerItemFood("crawfishetoufeeitem", 10, config.mealsaturation);
					saucedlambkebabItem = registerItemFood("saucedlambkebabitem", 10, config.mealsaturation);
					cantonesenoodlesItem = registerItemFood("cantonesenoodlesitem", 10, config.mealsaturation);
					dangoItem = registerItemFood("dangoitem", 10, config.mealsaturation);
					takoyakiItem = registerItemFood("takoyakiitem", 10, config.mealsaturation);
					
					springfieldcashewchickenItem = registerItemFood("springfieldcashewchickenitem", 11, config.mealsaturation);
					enchiladaItem = registerItemFood("enchiladaitem", 11, config.mealsaturation);
					pizzaItem = registerItemFood("pizzaitem", 11, config.mealsaturation);
					onionsoupItem = registerItemFood("onionsoupitem", 11, config.mealsaturation);
					baconmushroomburgerItem = registerItemFood("baconmushroomburgeritem", 11, config.mealsaturation);
					toadintheholeItem = registerItemFood("toadintheholeitem", 11, config.mealsaturation);
					homestylelunchItem = registerItemFood("homestylelunchitem", 11, config.mealsaturation);
					montecristosandwichItem = registerItemFood("montecristosandwichitem", 11, config.mealsaturation);

					//////////12 & 13 Food Points
					randomtacoItem = registerItemFood("randomtacoitem", 12, config.mealsaturation);
					hamsweetpicklesandwichItem = registerItemFood("hamsweetpicklesandwichitem", 12, config.mealsaturation);
					toastedwesternItem = registerItemFood("toastedwesternitem", 12, config.mealsaturation);
					eggsbenedictItem = registerItemFood("eggsbenedictitem", 12, config.mealsaturation);

					beetburgerItem = registerItemFood("beetburgeritem", 13, config.mealsaturation);
					anchovypepperonipizzaItem = registerItemFood("anchovypepperonipizzaitem", 13, config.mealsaturation);
					spaghettidinnerItem = registerItemFood("spaghettidinneritem", 13, config.mealsaturation);
					gumboItem = registerItemFood("gumboitem", 13, config.mealsaturation);
					jambalayaItem = registerItemFood("jambalayaitem", 13, config.mealsaturation);

					//////////14 & 15 Food Points
					supremepizzaItem = registerItemFood("supremepizzaitem", 14, config.mealsaturation);
					bbqplatterItem = registerItemFood("bbqplatteritem", 14, config.mealsaturation);
					chickenandwafflesItem = registerItemFood("chickenandwafflesitem", 14, config.mealsaturation);

					delightedmealItem = registerItemFood("delightedmealitem", 15, config.mealsaturation);
					heartybreakfastItem = registerItemFood("heartybreakfastitem", 15, config.mealsaturation);

					//////////16 & 17 Food Points
					mcpamItem = registerTopTierFood("mcpamitem", 16, config.mealsaturation);
					deluxenachoesItem = registerTopTierFood("deluxenachoesitem", 16, config.mealsaturation);
					
					chimichangaItem = registerTopTierFood("chimichangaitem", 17, config.mealsaturation);
					salisburysteakItem = registerTopTierFood("salisburysteakitem", 17, config.mealsaturation);

					//////////18 & 19 Food Points
					ploughmanslunchItem = registerTopTierFood("ploughmanslunchitem", 18, config.mealsaturation);
					cornedbeefhashItem = registerTopTierFood("cornedbeefhashitem", 18, config.mealsaturation);

					deluxechickencurryItem = registerTopTierFood("deluxechickencurryitem", 19, config.mealsaturation);
					weekendpicnicItem = registerTopTierFood("weekendpicnicitem", 19, config.mealsaturation);

					//////////20+ Food Points
					southernstylebreakfastItem = registerTopTierFood("southernstylebreakfastitem", 20, config.mealsaturation);

					meatfeastpizzaItem = registerTopTierFood("meatfeastpizzaitem", 24, config.mealsaturation);
					thankfuldinnerItem = registerTopTierFood("thankfuldinneritem", 24, config.mealsaturation);
					koreandinnerItem = registerTopTierFood("koreandinneritem", 24, config.mealsaturation);

					cornedbeefbreakfastItem = registerTopTierFood("cornedbeefbreakfastitem", 26, config.mealsaturation);
		}
		
		if (ConfigHandler.topTierFood == 9)
		{
				//////////10 & 11 Food Points
				baconcheeseburgerItem = registerItemFood("baconcheeseburgeritem", 10, config.mealsaturation);
				deluxecheeseburgerItem = registerItemFood("deluxecheeseburgeritem", 10, config.mealsaturation);
				beansontoastItem = registerItemFood("beansontoastitem", 10, config.mealsaturation);
				meatpieItem = registerItemFood("meatpieitem", 10, config.mealsaturation);
				chikorollItem = registerItemFood("chikorollitem", 10, config.mealsaturation);
				spinachpieItem = registerItemFood("spinachpieitem", 10, config.mealsaturation);
				coleslawburgerItem = registerItemFood("coleslawburgeritem", 10, config.mealsaturation);
				hotandsoursoupItem = registerItemFood("hotandsoursoupitem", 10, config.mealsaturation);
				patreonpieItem = registerItemFood("patreonpieitem", 10, config.mealsaturation);
				chilidogItem = registerItemFood("chilidogitem", 10, config.mealsaturation);
				tunafishsandwichItem = registerItemFood("tunafishsandwichitem", 10, config.mealsaturation);
				clamchowderItem = registerItemFood("clamchowderitem", 10, config.mealsaturation);
				breakfastburritoItem = registerItemFood("breakfastburritoitem", 10, config.mealsaturation);
				chipsandsalsaItem = registerItemFood("chipsandsalsaitem", 10, config.mealsaturation);
				crawfishetoufeeItem = registerItemFood("crawfishetoufeeitem", 10, config.mealsaturation);
				saucedlambkebabItem = registerItemFood("saucedlambkebabitem", 10, config.mealsaturation);
				cantonesenoodlesItem = registerItemFood("cantonesenoodlesitem", 10, config.mealsaturation);
				dangoItem = registerItemFood("dangoitem", 10, config.mealsaturation);
				takoyakiItem = registerItemFood("takoyakiitem", 10, config.mealsaturation);
				
				springfieldcashewchickenItem = registerItemFood("springfieldcashewchickenitem", 11, config.mealsaturation);
				enchiladaItem = registerItemFood("enchiladaitem", 11, config.mealsaturation);
				pizzaItem = registerItemFood("pizzaitem", 11, config.mealsaturation);
				onionsoupItem = registerItemFood("onionsoupitem", 11, config.mealsaturation);
				baconmushroomburgerItem = registerItemFood("baconmushroomburgeritem", 11, config.mealsaturation);
				toadintheholeItem = registerItemFood("toadintheholeitem", 11, config.mealsaturation);
				homestylelunchItem = registerItemFood("homestylelunchitem", 11, config.mealsaturation);
				montecristosandwichItem = registerItemFood("montecristosandwichitem", 11, config.mealsaturation);

				//////////12 & 13 Food Points
				randomtacoItem = registerItemFood("randomtacoitem", 12, config.mealsaturation);
				hamsweetpicklesandwichItem = registerItemFood("hamsweetpicklesandwichitem", 12, config.mealsaturation);
				toastedwesternItem = registerItemFood("toastedwesternitem", 12, config.mealsaturation);
				eggsbenedictItem = registerItemFood("eggsbenedictitem", 12, config.mealsaturation);

				beetburgerItem = registerItemFood("beetburgeritem", 13, config.mealsaturation);
				anchovypepperonipizzaItem = registerItemFood("anchovypepperonipizzaitem", 13, config.mealsaturation);
				spaghettidinnerItem = registerItemFood("spaghettidinneritem", 13, config.mealsaturation);
				gumboItem = registerItemFood("gumboitem", 13, config.mealsaturation);
				jambalayaItem = registerItemFood("jambalayaitem", 13, config.mealsaturation);

				//////////14 & 15 Food Points
				supremepizzaItem = registerItemFood("supremepizzaitem", 14, config.mealsaturation);
				bbqplatterItem = registerItemFood("bbqplatteritem", 14, config.mealsaturation);
				chickenandwafflesItem = registerItemFood("chickenandwafflesitem", 14, config.mealsaturation);

				delightedmealItem = registerItemFood("delightedmealitem", 15, config.mealsaturation);
				heartybreakfastItem = registerItemFood("heartybreakfastitem", 15, config.mealsaturation);

				//////////16 & 17 Food Points
				mcpamItem = registerItemFood("mcpamitem", 16, config.mealsaturation);
				deluxenachoesItem = registerItemFood("deluxenachoesitem", 16, config.mealsaturation);
				
				chimichangaItem = registerItemFood("chimichangaitem", 17, config.mealsaturation);
				salisburysteakItem = registerItemFood("salisburysteakitem", 17, config.mealsaturation);

				//////////18 & 19 Food Points
				ploughmanslunchItem = registerTopTierFood("ploughmanslunchitem", 18, config.mealsaturation);
				cornedbeefhashItem = registerTopTierFood("cornedbeefhashitem", 18, config.mealsaturation);

				deluxechickencurryItem = registerTopTierFood("deluxechickencurryitem", 19, config.mealsaturation);
				weekendpicnicItem = registerTopTierFood("weekendpicnicitem", 19, config.mealsaturation);

				//////////20+ Food Points
				southernstylebreakfastItem = registerTopTierFood("southernstylebreakfastitem", 20, config.mealsaturation);

				meatfeastpizzaItem = registerTopTierFood("meatfeastpizzaitem", 24, config.mealsaturation);
				thankfuldinnerItem = registerTopTierFood("thankfuldinneritem", 24, config.mealsaturation);
				koreandinnerItem = registerTopTierFood("koreandinneritem", 24, config.mealsaturation);

				cornedbeefbreakfastItem = registerTopTierFood("cornedbeefbreakfastitem", 26, config.mealsaturation);
		}
		
		if (ConfigHandler.topTierFood == 10)
		{
			//////////10 & 11 Food Points
			baconcheeseburgerItem = registerItemFood("baconcheeseburgeritem", 10, config.mealsaturation);
			deluxecheeseburgerItem = registerItemFood("deluxecheeseburgeritem", 10, config.mealsaturation);
			beansontoastItem = registerItemFood("beansontoastitem", 10, config.mealsaturation);
			meatpieItem = registerItemFood("meatpieitem", 10, config.mealsaturation);
			chikorollItem = registerItemFood("chikorollitem", 10, config.mealsaturation);
			spinachpieItem = registerItemFood("spinachpieitem", 10, config.mealsaturation);
			coleslawburgerItem = registerItemFood("coleslawburgeritem", 10, config.mealsaturation);
			hotandsoursoupItem = registerItemFood("hotandsoursoupitem", 10, config.mealsaturation);
			patreonpieItem = registerItemFood("patreonpieitem", 10, config.mealsaturation);
			chilidogItem = registerItemFood("chilidogitem", 10, config.mealsaturation);
			tunafishsandwichItem = registerItemFood("tunafishsandwichitem", 10, config.mealsaturation);
			clamchowderItem = registerItemFood("clamchowderitem", 10, config.mealsaturation);
			breakfastburritoItem = registerItemFood("breakfastburritoitem", 10, config.mealsaturation);
			chipsandsalsaItem = registerItemFood("chipsandsalsaitem", 10, config.mealsaturation);
			crawfishetoufeeItem = registerItemFood("crawfishetoufeeitem", 10, config.mealsaturation);
			saucedlambkebabItem = registerItemFood("saucedlambkebabitem", 10, config.mealsaturation);
			cantonesenoodlesItem = registerItemFood("cantonesenoodlesitem", 10, config.mealsaturation);
			dangoItem = registerItemFood("dangoitem", 10, config.mealsaturation);
			takoyakiItem = registerItemFood("takoyakiitem", 10, config.mealsaturation);
			
			springfieldcashewchickenItem = registerItemFood("springfieldcashewchickenitem", 11, config.mealsaturation);
			enchiladaItem = registerItemFood("enchiladaitem", 11, config.mealsaturation);
			pizzaItem = registerItemFood("pizzaitem", 11, config.mealsaturation);
			onionsoupItem = registerItemFood("onionsoupitem", 11, config.mealsaturation);
			baconmushroomburgerItem = registerItemFood("baconmushroomburgeritem", 11, config.mealsaturation);
			toadintheholeItem = registerItemFood("toadintheholeitem", 11, config.mealsaturation);
			homestylelunchItem = registerItemFood("homestylelunchitem", 11, config.mealsaturation);
			montecristosandwichItem = registerItemFood("montecristosandwichitem", 11, config.mealsaturation);

			//////////12 & 13 Food Points
			randomtacoItem = registerItemFood("randomtacoitem", 12, config.mealsaturation);
			hamsweetpicklesandwichItem = registerItemFood("hamsweetpicklesandwichitem", 12, config.mealsaturation);
			toastedwesternItem = registerItemFood("toastedwesternitem", 12, config.mealsaturation);
			eggsbenedictItem = registerItemFood("eggsbenedictitem", 12, config.mealsaturation);

			beetburgerItem = registerItemFood("beetburgeritem", 13, config.mealsaturation);
			anchovypepperonipizzaItem = registerItemFood("anchovypepperonipizzaitem", 13, config.mealsaturation);
			spaghettidinnerItem = registerItemFood("spaghettidinneritem", 13, config.mealsaturation);
			gumboItem = registerItemFood("gumboitem", 13, config.mealsaturation);
			jambalayaItem = registerItemFood("jambalayaitem", 13, config.mealsaturation);

			//////////14 & 15 Food Points
			supremepizzaItem = registerItemFood("supremepizzaitem", 14, config.mealsaturation);
			bbqplatterItem = registerItemFood("bbqplatteritem", 14, config.mealsaturation);
			chickenandwafflesItem = registerItemFood("chickenandwafflesitem", 14, config.mealsaturation);

			delightedmealItem = registerItemFood("delightedmealitem", 15, config.mealsaturation);
			heartybreakfastItem = registerItemFood("heartybreakfastitem", 15, config.mealsaturation);

			//////////16 & 17 Food Points
			mcpamItem = registerItemFood("mcpamitem", 16, config.mealsaturation);
			deluxenachoesItem = registerItemFood("deluxenachoesitem", 16, config.mealsaturation);
			
			chimichangaItem = registerItemFood("chimichangaitem", 17, config.mealsaturation);
			salisburysteakItem = registerItemFood("salisburysteakitem", 17, config.mealsaturation);

			//////////18 & 19 Food Points
			ploughmanslunchItem = registerItemFood("ploughmanslunchitem", 18, config.mealsaturation);
			cornedbeefhashItem = registerItemFood("cornedbeefhashitem", 18, config.mealsaturation);

			deluxechickencurryItem = registerItemFood("deluxechickencurryitem", 19, config.mealsaturation);
			weekendpicnicItem = registerItemFood("weekendpicnicitem", 19, config.mealsaturation);

			//////////20+ Food Points
			southernstylebreakfastItem = registerTopTierFood("southernstylebreakfastitem", 20, config.mealsaturation);

			meatfeastpizzaItem = registerTopTierFood("meatfeastpizzaitem", 24, config.mealsaturation);
			thankfuldinnerItem = registerTopTierFood("thankfuldinneritem", 24, config.mealsaturation);
			koreandinnerItem = registerTopTierFood("koreandinneritem", 24, config.mealsaturation);

			cornedbeefbreakfastItem = registerTopTierFood("cornedbeefbreakfastitem", 26, config.mealsaturation);
		}
		
		if (ConfigHandler.topTierFood == 0)
		{
			//////////10 & 11 Food Points
			baconcheeseburgerItem = registerItemFood("baconcheeseburgeritem", 10, config.mealsaturation);
			deluxecheeseburgerItem = registerItemFood("deluxecheeseburgeritem", 10, config.mealsaturation);
			beansontoastItem = registerItemFood("beansontoastitem", 10, config.mealsaturation);
			meatpieItem = registerItemFood("meatpieitem", 10, config.mealsaturation);
			chikorollItem = registerItemFood("chikorollitem", 10, config.mealsaturation);
			spinachpieItem = registerItemFood("spinachpieitem", 10, config.mealsaturation);
			coleslawburgerItem = registerItemFood("coleslawburgeritem", 10, config.mealsaturation);
			hotandsoursoupItem = registerItemFood("hotandsoursoupitem", 10, config.mealsaturation);
			patreonpieItem = registerItemFood("patreonpieitem", 10, config.mealsaturation);
			chilidogItem = registerItemFood("chilidogitem", 10, config.mealsaturation);
			tunafishsandwichItem = registerItemFood("tunafishsandwichitem", 10, config.mealsaturation);
			clamchowderItem = registerItemFood("clamchowderitem", 10, config.mealsaturation);
			breakfastburritoItem = registerItemFood("breakfastburritoitem", 10, config.mealsaturation);
			chipsandsalsaItem = registerItemFood("chipsandsalsaitem", 10, config.mealsaturation);
			crawfishetoufeeItem = registerItemFood("crawfishetoufeeitem", 10, config.mealsaturation);
			saucedlambkebabItem = registerItemFood("saucedlambkebabitem", 10, config.mealsaturation);
			cantonesenoodlesItem = registerItemFood("cantonesenoodlesitem", 10, config.mealsaturation);
			dangoItem = registerItemFood("dangoitem", 10, config.mealsaturation);
			takoyakiItem = registerItemFood("takoyakiitem", 10, config.mealsaturation);
			
			springfieldcashewchickenItem = registerItemFood("springfieldcashewchickenitem", 11, config.mealsaturation);
			enchiladaItem = registerItemFood("enchiladaitem", 11, config.mealsaturation);
			pizzaItem = registerItemFood("pizzaitem", 11, config.mealsaturation);
			onionsoupItem = registerItemFood("onionsoupitem", 11, config.mealsaturation);
			baconmushroomburgerItem = registerItemFood("baconmushroomburgeritem", 11, config.mealsaturation);
			toadintheholeItem = registerItemFood("toadintheholeitem", 11, config.mealsaturation);
			homestylelunchItem = registerItemFood("homestylelunchitem", 11, config.mealsaturation);
			montecristosandwichItem = registerItemFood("montecristosandwichitem", 11, config.mealsaturation);

			//////////12 & 13 Food Points
			randomtacoItem = registerItemFood("randomtacoitem", 12, config.mealsaturation);
			hamsweetpicklesandwichItem = registerItemFood("hamsweetpicklesandwichitem", 12, config.mealsaturation);
			toastedwesternItem = registerItemFood("toastedwesternitem", 12, config.mealsaturation);
			eggsbenedictItem = registerItemFood("eggsbenedictitem", 12, config.mealsaturation);

			beetburgerItem = registerItemFood("beetburgeritem", 13, config.mealsaturation);
			anchovypepperonipizzaItem = registerItemFood("anchovypepperonipizzaitem", 13, config.mealsaturation);
			spaghettidinnerItem = registerItemFood("spaghettidinneritem", 13, config.mealsaturation);
			gumboItem = registerItemFood("gumboitem", 13, config.mealsaturation);
			jambalayaItem = registerItemFood("jambalayaitem", 13, config.mealsaturation);

			//////////14 & 15 Food Points
			supremepizzaItem = registerItemFood("supremepizzaitem", 14, config.mealsaturation);
			bbqplatterItem = registerItemFood("bbqplatteritem", 14, config.mealsaturation);
			chickenandwafflesItem = registerItemFood("chickenandwafflesitem", 14, config.mealsaturation);

			delightedmealItem = registerItemFood("delightedmealitem", 15, config.mealsaturation);
			heartybreakfastItem = registerItemFood("heartybreakfastitem", 15, config.mealsaturation);

			//////////16 & 17 Food Points
			mcpamItem = registerItemFood("mcpamitem", 16, config.mealsaturation);
			deluxenachoesItem = registerItemFood("deluxenachoesitem", 16, config.mealsaturation);
			
			chimichangaItem = registerItemFood("chimichangaitem", 17, config.mealsaturation);
			salisburysteakItem = registerItemFood("salisburysteakitem", 17, config.mealsaturation);

			//////////18 & 19 Food Points
			ploughmanslunchItem = registerItemFood("ploughmanslunchitem", 18, config.mealsaturation);
			cornedbeefhashItem = registerItemFood("cornedbeefhashitem", 18, config.mealsaturation);

			deluxechickencurryItem = registerItemFood("deluxechickencurryitem", 19, config.mealsaturation);
			weekendpicnicItem = registerItemFood("weekendpicnicitem", 19, config.mealsaturation);

			//////////20+ Food Points
			southernstylebreakfastItem = registerItemFood("southernstylebreakfastitem", 20, config.mealsaturation);

			meatfeastpizzaItem = registerItemFood("meatfeastpizzaitem", 24, config.mealsaturation);
			thankfuldinnerItem = registerItemFood("thankfuldinneritem", 24, config.mealsaturation);
			koreandinnerItem = registerItemFood("koreandinneritem", 24, config.mealsaturation);

			cornedbeefbreakfastItem = registerItemFood("cornedbeefbreakfastitem", 26, config.mealsaturation);
		}

	}

	private static void registerTools() {
		cuttingboardItem = registerItemTool("cuttingboarditem");
		potItem = registerItemTool("potitem");
		skilletItem = registerItemTool("skilletitem");
		saucepanItem = registerItemTool("saucepanitem");
		bakewareItem = registerItemTool("bakewareitem");
		mortarandpestleItem = registerItemTool("mortarandpestleitem");
		mixingbowlItem = registerItemTool("mixingbowlitem");
		juicerItem = registerItemTool("juiceritem");
	}

	public static void registerFish() {
		anchovyrawItem = registerRawFish("anchovyrawitem");
		bassrawItem = registerRawFish("bassrawitem");
		carprawItem = registerRawFish("carprawitem");
		catfishrawItem = registerRawFish("catfishrawitem");
		charrrawItem = registerRawFish("charrrawitem");
		clamrawItem = registerRawFish("clamrawitem");
		crabrawItem = registerRawFish("crabrawitem");
		crayfishrawItem = registerRawFish("crayfishrawitem");
		eelrawItem = registerRawFish("eelrawitem");
		frograwItem = registerRawFish("frograwitem");
		grouperrawItem = registerRawFish("grouperrawitem");
		herringrawItem = registerRawFish("herringrawitem");
		jellyfishrawItem = registerRawFish("jellyfishrawitem");
		mudfishrawItem = registerRawFish("mudfishrawitem");
		octopusrawItem = registerRawFish("octopusrawitem");
		perchrawItem = registerRawFish("perchrawitem");
		scalloprawItem = registerRawFish("scalloprawitem");
		shrimprawItem = registerRawFish("shrimprawitem");
		snailrawItem = registerRawFish("snailrawitem");
		snapperrawItem = registerRawFish("snapperrawitem");
		tilapiarawItem = registerRawFish("tilapiarawitem");
		troutrawItem = registerRawFish("troutrawitem");
		tunarawItem = registerRawFish("tunarawitem");
		turtlerawItem = registerRawFish("turtlerawitem");
		walleyerawItem = registerRawFish("walleyerawitem");
		greenheartfishItem = registerRawFish("greenheartfishitem");
		sardinerawItem = registerRawFish("sardinerawitem");
		musselrawItem = registerRawFish("musselrawitem");
		rawtofishItem = registerRawFish("rawtofishitem");
		oysterrawItem = registerRawFish("oysterrawitem");
		
	}

	private static void registerJuices() {
		applejuiceItem = registerJuice("applejuiceitem");
		melonjuiceItem = registerJuice("melonjuiceitem");
		carrotjuiceItem = registerJuice("carrotjuiceitem");
		strawberryjuiceItem = registerJuice("strawberryjuiceitem");
		grapejuiceItem = registerJuice("grapejuiceitem");
		blueberryjuiceItem = registerJuice("blueberryjuiceitem");
		cherryjuiceItem = registerJuice("cherryjuiceitem");
		papayajuiceItem = registerJuice("papayajuiceitem");
		starfruitjuiceItem = registerJuice("starfruitjuiceitem");
		orangejuiceItem = registerJuice("orangejuiceitem");
		peachjuiceItem = registerJuice("peachjuiceitem");
		limejuiceItem = registerJuice("limejuiceitem");
		mangojuiceItem = registerJuice("mangojuiceitem");
		pomegranatejuiceItem = registerJuice("pomegranatejuiceitem");
		blackberryjuiceItem = registerJuice("blackberryjuiceitem");
		raspberryjuiceItem = registerJuice("raspberryjuiceitem");
		kiwijuiceItem = registerJuice("kiwijuiceitem");
		cranberryjuiceItem = registerJuice("cranberryjuiceitem");
		cactusfruitjuiceItem = registerJuice("cactusfruitjuiceitem");
		plumjuiceItem = registerJuice("plumjuiceitem");
		pearjuiceItem = registerJuice("pearjuiceitem");
		apricotjuiceItem = registerJuice("apricotjuiceitem");
		figjuiceItem = registerJuice("figjuiceitem");
		grapefruitjuiceItem = registerJuice("grapefruitjuiceitem");
		persimmonjuiceItem = registerJuice("persimmonjuiceitem");
	}

	private static Item registerItemTool(String registryName) {
		final ItemPamTool item = new ItemPamTool();
		item.setContainerItem(item);

		return registerItem(item, registryName);
	}
	
	private static Item registerItemPamBee(String registryName) {
		final Item item = new ItemPamBee();

		return registerItem(item, registryName);
	}

	private static Item registerItemArmor(String registryName, EntityEquipmentSlot slot) {
		final ItemPamHardenedLeatherArmor item = new ItemPamHardenedLeatherArmor(slot);

		return registerItem(item, registryName);
	}

	private static Item registerItemVanillaFood(String registryName, int amount, float saturation, boolean isWolfsFavoriteMeat) {
		final Item item = new ItemFood(amount, saturation, isWolfsFavoriteMeat);
		allFood.add(item);

		return registerItem(item, registryName);
	}
	
	private static Item registerItemFood(String registryName, int amount, float saturation) {
		final Item item = new ItemPamFood(amount, saturation);
		allFood.add(item);

		return registerItem(item, registryName);
	}
	
	private static ItemSeedFood registerItemSeedFood(String registryName, int amount, float saturation, Block crops, Block soil) {
		final Item item = new ItemSeedFood(amount, saturation, crops, soil);
		allFood.add(item);
		return (ItemSeedFood) registerItem(item, registryName);
	}

	private static Item registerItemPamCakeFood(String registryName, int amount, float saturation,
			BlockPamCake blockpamcake) {
		Item item = new ItemPamCakeFood(amount, saturation, initialized, blockpamcake);
		allFood.add(item);

		return registerItem(item, registryName);
	}

	private static Item registerJuice(String juiceName) {
		final Item juiceItem = registerPotionFood(juiceName, 2, config.mealsaturation);
		allJuice.add(juiceItem);

		return juiceItem;
	}

	public static Item registerRawFish(String fishName) {
		final Item fishItem = registerItemFood(fishName, 1, config.snacksaturation);

		allFishRaw.add(fishItem);

		return fishItem;
	}

	private static Item registerGenericItem(String registryName) {
		final Item item = new Item();

		return registerItem(item, registryName);
	}

	private static ItemPamPotionFood registerPotionFood(String registryName, int amount, float saturation) {
		final Item item = new ItemPamPotionFood(amount, saturation, false).addDefaultSpeedPotionEffect();

		return (ItemPamPotionFood) registerItem(item, registryName);
	}
	
	private static ItemPamTopTierFood registerTopTierFood(String registryName, int amount, float saturation) {
		//final Item item = new ItemPamTopTierFood(amount, saturation, false).addDefaultStrengthPotionEffect().addDefaultResistancePotionEffect();
		final Item item = new ItemPamTopTierFood(amount, saturation, false);
		
		return (ItemPamTopTierFood) registerItem(item, registryName);
	}

    public static Item registerItem(Item item, String registryName) {
        item.setCreativeTab(HarvestCraft.modTab);
        item.setRegistryName(registryName);
        item.setUnlocalizedName(registryName);
        itemlist.add(item);
        return item;
    }
    
    @SubscribeEvent
    public void onItemRegistry(RegistryEvent.Register<Item> e) {
        IForgeRegistry<Item> reg = e.getRegistry();
        reg.registerAll(itemlist.toArray(new Item[0]));
        GeneralOreRegistry.initOreRegistry();
    }
}
