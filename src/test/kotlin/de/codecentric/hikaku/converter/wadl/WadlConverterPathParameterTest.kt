package de.codecentric.hikaku.converter.wadl

import de.codecentric.hikaku.endpoints.PathParameter
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Paths


class WadlConverterPathParameterTest {

    @Test
    fun `check that path parameter are extracted correctly`() {
        //given
        val file = Paths.get(WadlConverterPathParameterTest::class.java.classLoader.getResource("wadl/path_parameter.wadl").toURI())
        val pathParameter = PathParameter("id")

        //when
        val specification = WadlConverter(file)

        //then
        val resultingPathParameters = specification.conversionResult.toList()[0].pathParameters
        assertThat(resultingPathParameters).containsExactly(pathParameter)
    }
}