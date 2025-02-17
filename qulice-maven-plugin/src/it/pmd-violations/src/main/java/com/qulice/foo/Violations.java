/*
 * Copyright (c) 2011-2021, Qulice.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met: 1) Redistributions of source code must retain the above
 * copyright notice, this list of conditions and the following
 * disclaimer. 2) Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution. 3) Neither the name of the Qulice.com nor
 * the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.qulice.foo;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Sample class.
 * @since 1.0
 */
public final class Violations {
    /**
     * Unused variable - PMD should report a violation here.
     */
    private Integer var;

    /**
     * Calculate square of a number.
     * @param num The number
     * @return The square
     * @checkstyle NonStaticMethod (2 lines)
     */
    public int square(final int num) {
        return num * num;
    }

    /**
     * Returns Foo.
     * @return Foo.
     * @checkstyle NonStaticMethod (2 lines)
     */
    public Foo doSmth() {
        final String name = "test".toUpperCase();
        return new Foo(name);
    }

    /**
     * Returns Foo again.
     * @return Foo.
     * @checkstyle NonStaticMethod (2 lines)
     */
    public Foo doSmthElse() {
        String name = "other";
        name = String.format("%s append", name);
        return new Foo(name);
    }

    /**
     * Prints something.
     * @checkstyle NonStaticMethod (2 lines)
     */
    public void print() {
        final String message = "hello";
        System.out.println(message);
    }

    /**
     * Test class.
     */
    private static final class Foo {
        /**
         * Name.
         */
        private final transient String name;

        /**
         * Constructor.
         * @param nam Name.
         */
        Foo(final String nam) {
            this.name = nam;
        }

        @Override
        public String toString() {
            return this.name;
        }

        public String something() {
            return Stream.of(" one", " two")
                .map(str -> str.trim())
                .collect(Collectors.joining());

        }
    }
}

