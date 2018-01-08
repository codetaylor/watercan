```
# Configuration file

##########################################################################################################
# 1 - client
#--------------------------------------------------------------------------------------------------------#
# Turn off all the particles spawned by the water can here.
##########################################################################################################

"1 - client" {
    #  [default: true]
    B:spawnWaterParticles=true
}


##########################################################################################################
# 2 - capacity
#--------------------------------------------------------------------------------------------------------#
# How much water could a water can can if a water can could can water?
# Capacity in millibuckets.
# 
# Set to zero to make the can never run out of water.
##########################################################################################################

"2 - capacity" {
    #  [range: 0 ~ 2147483647, default: 0]
    I:diamond=0

    #  [range: 0 ~ 2147483647, default: 4000]
    I:gold=4000

    #  [range: 0 ~ 2147483647, default: 4000]
    I:iron=4000

    #  [range: 0 ~ 2147483647, default: 2000]
    I:stone=2000

    #  [range: 0 ~ 2147483647, default: 1000]
    I:wood=1000
}


##########################################################################################################
# 3 - range
#--------------------------------------------------------------------------------------------------------#
# This is the radius that the water can will spread out from the targeted block.
# For example, a radius of one will water a 3x3 area and a radius of two will water a 5x5 area.
##########################################################################################################

"3 - range" {
    #  [range: 0 ~ 8, default: 2]
    I:diamond=2

    #  [range: 0 ~ 8, default: 1]
    I:gold=1

    #  [range: 0 ~ 8, default: 1]
    I:iron=1

    #  [range: 0 ~ 8, default: 1]
    I:stone=1

    #  [range: 0 ~ 8, default: 0]
    I:wood=0
}


##########################################################################################################
# 4 - flower chance
#--------------------------------------------------------------------------------------------------------#
# The flower chance controls the spawn rate of flowers on watered grass blocks.
# The higher the number the higher the chance to spawn flowers while watering.
# Range: 0 to 100
##########################################################################################################

"4 - flower chance" {
    #  [range: 0 ~ 100, default: 2]
    I:diamond=2

    #  [range: 0 ~ 100, default: 50]
    I:gold=50

    #  [range: 0 ~ 100, default: 1]
    I:iron=1

    #  [range: 0 ~ 100, default: 1]
    I:stone=1

    #  [range: 0 ~ 100, default: 0]
    I:wood=0
}


##########################################################################################################
# 5 - delay modifier
#--------------------------------------------------------------------------------------------------------#
# Use the delay modifier to speed up or slow down growth.
# Range: 1 to 40 (smaller is faster)
##########################################################################################################

"5 - delay modifier" {
    #  [range: 1 ~ 40, default: 10]
    I:diamond=10

    #  [range: 1 ~ 40, default: 40]
    I:gold=40

    #  [range: 1 ~ 40, default: 10]
    I:iron=10

    #  [range: 1 ~ 40, default: 15]
    I:stone=15

    #  [range: 1 ~ 40, default: 5]
    I:wood=5
}


##########################################################################################################
# 6 - consume water source
#--------------------------------------------------------------------------------------------------------#
# Set to true to consume the water source block when refilling the watercan.
##########################################################################################################

"6 - consume water source" {
    #  [default: false]
    B:diamond=false

    #  [default: false]
    B:gold=false

    #  [default: false]
    B:iron=false

    #  [default: false]
    B:stone=false

    #  [default: false]
    B:wood=false
}
```