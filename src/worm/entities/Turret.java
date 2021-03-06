/*
 * Copyright (c) 2003-onwards Shaven Puppy Ltd
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'Shaven Puppy' nor the names of its contributors
 *   may be used to endorse or promote products derived from this software
 *   without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package worm.entities;

import worm.buildings.TurretBuildingFeature;
import worm.weapons.WeaponFeature;

/**
 * Specialised extension to buildings for turrets
 * @author Cas
 */
public abstract class Turret extends Building {

	private static final long serialVersionUID = 1L;

	/**
	 * C'tor
	 * @param feature
	 * @param x
	 * @param y
	 */
	protected Turret(TurretBuildingFeature feature, boolean ghost) {
		super(feature, ghost);
	}

	/**
	 * @return the Weapon used by the turret
	 */
	public abstract WeaponFeature.WeaponInstance getWeapon();

	/**
	 * Set the weapon used by the turret
	 * @param weapon
	 */
	public abstract void setWeapon(WeaponFeature.WeaponInstance weapon);

	/**
	 * @return the scanning radius for this turret
	 */
	public abstract float getScanRadius();

	/**
	 * Called when the weapon has reloaded
	 */
	@Override
	public abstract void onReloaded();

	/**
	 * @return true if this turret is currently aiming at aerial targets (only really applies to the Laser Turret)
	 */
	public abstract boolean isFiringAtAerialTargets();
}
