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
package com.shavenpuppy.jglib.interpolators;

import java.io.ObjectInput;
import java.io.ObjectStreamException;

import com.shavenpuppy.jglib.util.FPMath;

/**
 * A cosine interpolator. Access using instance member variable.
 * Creation date: (30/03/2001 01:19:35)
 * @author: cas
 */
public final class SineInterpolator extends InterpolatorBase {
	private static final long serialVersionUID = 1L;

	public static final SineInterpolator instance = new SineInterpolator();

	/**
	 * CosineInterpolator can only be accessed as a singleton.
	 */
	private SineInterpolator() {
		super();
	}
	/**
	 * Sine interpolation.
	 */
	@Override
	public float interpolate(float a, float b, float ratio) {
		if (a == b) {
			return a;
		}
		if (ratio < 0.0f) {
			ratio = 0.0f;
		} else if (ratio > 1.0f) {
			ratio = 1.0f;
		}
		double ft = ratio * Math.PI / 2.0;
		double f = Math.sin(ft);
		return (float) (a * (1.0f - f) + b * f);
	}
	/**
	 * Sine interpolation.
	 */
	@Override
	public int interpolate(int a, int b, int ratio) {
		if (a == b) {
			return a;
		}
		if (ratio < 0) {
			ratio = 0;
		} else if (ratio > FPMath.ONE) {
			ratio = FPMath.ONE;
		}
		int f = FPMath.sin(ratio >> 2);
		return LinearInterpolator.instance.interpolate(a, b, f);
	}

	private Object readResolve(ObjectInput oi) throws ObjectStreamException {
		return instance;
	}

}
