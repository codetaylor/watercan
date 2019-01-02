1.0.0

  NOTE: This version is a major rewrite of the mod and the major version bump reflects this. Everything has changed, including the config file name and contents, mod id, and the item ids.

  * Changed:
    * Mod id is now `watercan`
    * Item ids are now: `watercan:watercan_wood`, `watercan:watercan_stone`, `watercan:watercan_iron`, `watercan:watercan_gold`, `watercan:watercan_diamond`

  * Added:
    * Config file includes booleans to enable / disable:
      * growing crops
      * growing saplings
      * growing flowers
      * spreading grass
      * spreading mycelium
      * extinguishing fire
      * moisturizing farmland

  * Requires: Athenaeum >= 1.15.0

---

0.6.0

  * Changed:
    * Watercan durability bar color changed from green to blue

---

0.5.6
* Fixed: server crash (#4)

0.5.5
* Added: config option to consume source block when refilling the watercans
* Added: tooltip to display capacity
* Changed: watercan max capacity from 2^31 - 1 to 32767

0.4.5
* Merged zh_CN.lang

0.4.4
* Fix: server crash

0.4.3
* Updated for 1.12.2.
* Added bonemeal to default recipes.

0.4.0
* Added: gold watercan - grows crops at the slowest speed, but grows flowers on grass very fast (please refresh configs for kor-watercan or there will be no recipe for this new can)

0.3.0
* Fix: all watercans grow things at the same speed (really fast - was hardcoded for testing, forgot to remove it)
* Fix: texture alignment

0.2.0
* Initial release