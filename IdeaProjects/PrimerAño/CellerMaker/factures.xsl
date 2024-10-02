<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" version="5.0"/> <!--salida html-->
    <xsl:key name="producte" match="producte" use="@codi"/>

    <xsl:template match="celler">
        <html>
            <head>
                <title>Factures</title>
                <link rel="stylesheet" type="text/css" href="celler.css"/>
            </head>
            <body>
                <table>
                    <xsl:apply-templates select="clients/client" mode="second">
                        <xsl:sort select="string(count(//factura[comprador/@codi=current()/@codi]))"/>
                    </xsl:apply-templates>
                </table>
            </body>
        </html>
    </xsl:template>

     <xsl:template match="factura" mode="principal">
        <tr><td><xsl:value-of select="@codi"/></td></tr>
        <xsl:variable name="comprador" select="comprador/@codi"/>
        <tr>
            <td><xsl:value-of select="$comprador"/></td>
            <td><xsl:value-of select="/celler/clients/client[@codi=$comprador]/nom"/></td>
        </tr>

        <xsl:for-each select="unitats">
            <tr>
                <xsl:variable name="unitats" select="@codi"/>
                <td><xsl:value-of select="$unitats"/></td>
                <xsl:variable name="producte" select="key('producte', $unitats)"/>
                <td><xsl:value-of select="$producte"/></td>
                <td><xsl:value-of select="current()"/></td>
                <td class="preu"><xsl:value-of select="format-number (number ($producte/@preu), '#.00€')"/></td>
                <td class="preu"><xsl:value-of select="format-number (current () * number ($producte/@preu), '#.00€')"/></td>
            </tr>
        </xsl:for-each>

        <xsl:call-template name="buides">
            <xsl:with-param name="contador" select="1 + count(unitats)"/>
        </xsl:call-template>

        <tr>
            <td><xsl:value-of select="count(unitats)"/></td>
        </tr>
        <tr>
            <td colspan="4"/>
            <td class="preuTotal"><xsl:value-of select="format-number(sum(unitats/(. * key('producte', @codi)/@preu)), '#.00€')"/></td>
        </tr>
    </xsl:template>

    <xsl:template match="client" mode="second">

        <xsl:variable name="codiC" select="@codi"/>

        <xsl:variable name="factures" select="//factura[comprador/@codi=$codiC]"/>

        <tr>
            <td><xsl:value-of select="@codi"/></td>
            <td><xsl:value-of select="nom"/></td>
            <td><xsl:value-of select="count($factures)"/></td>


            <xsl:for-each select="$factures">
                <td><xsl:value-of select="@codi"/></td>
            </xsl:for-each>
        </tr>
    </xsl:template>

    <xsl:template name="buides">
        <xsl:param name="contador"/>
        <xsl:if test="13 > $contador">
            <tr>
                <td/>
                <td/>
                <td/>
                <td class="preu"/>
                <td class="preu"/>
            </tr>
            <xsl:call-template name="buides">
                <xsl:with-param name="contador" select="1 + $contador"/>
            </xsl:call-template>
        </xsl:if>

    </xsl:template>
</xsl:stylesheet>