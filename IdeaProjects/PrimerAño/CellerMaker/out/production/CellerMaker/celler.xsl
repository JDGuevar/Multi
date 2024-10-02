<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html" version="5.0"/>
    <xsl:template match="celler">
        <html>
            <head>
                <title>Celler</title>
                <link rel="stylesheet" type="text/css" href="celler.css"/>
            </head>
            <body>
                    <xsl:apply-templates select="factures/factura"/>
            </body>
        </html>
    </xsl:template>

    <xsl:template name="compra">
        <xsl:param name="contador"/>
        <xsl:choose>
            <xsl:when test="unitats[$contador]">
                <xsl:variable name="codi_producte" select="unitats[$contador]/@codi"/>
                <xsl:variable name="producte" select="key('producte', $codi_producte)"/>
                <xsl:variable name="preu" select="$producte/@preu"/>
                <div class="datos c2"><xsl:value-of select="$codi_producte"/></div>
                <div class="datos c2"><xsl:value-of select="unitats[$contador]"/></div>
                <div class="datos c9"><xsl:value-of select="$producte"/></div>
                <div class="datos c3"><xsl:value-of select="format-number ($preu, '#.00€')"/></div>
                <div class="datos c3"><xsl:value-of select="format-number ($preu * unitats[$contador], '#.00€')"/></div>
                <xsl:call-template name="compra">
                    <xsl:with-param name="contador" select="1 + $contador"/>
                </xsl:call-template>
            </xsl:when>
            <xsl:otherwise>
                <xsl:if test="13 > $contador">
                    <div class="datos c2"> </div>
                    <div class="datos c2"> </div>
                    <div class="datos c9"> </div>
                    <div class="datos c3"> </div>
                    <div class="datos c3"> </div>
                    <xsl:call-template name="compra">
                        <xsl:with-param name="contador" select="1 + $contador"/>
                    </xsl:call-template>
                </xsl:if>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>

</xsl:stylesheet>