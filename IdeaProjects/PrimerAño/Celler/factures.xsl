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
                    <xsl:apply-templates select="//factura" mode="principal">
                        <xsl:sort select="@numero"/>
                    </xsl:apply-templates>
            </body>
        </html>
    </xsl:template>

     <xsl:template match="factura" mode="principal">
         <table class="factura">
                <tr class="header">
                    <td colspan="5">Celler<br/>Guevara</td>
                </tr>

             <tr class="noVisible">
                 <td colspan="5"/>
             </tr>

             <tr class="header1"><td>Codi</td> <td colspan="2">Comprador</td> <td colspan="2">Factura</td></tr>
              <xsl:variable name="comprador" select="comprador/@codi"/>
             <tr class="header2">
                  <td><xsl:value-of select="$comprador"/></td>
                  <td colspan="2"><xsl:value-of select="/celler/clients/client[@codi=$comprador]/nom"/></td>
                 <td colspan="2"><xsl:value-of select="@numero"/></td>
             </tr>

             <tr class="header1">
                 <td>Contacto:</td>
                 <xsl:variable name="telefono" select="/celler/clients/client[@codi=$comprador]/telefon[1]"/>
                 <xsl:variable name="telefono2" select="/celler/clients/client[@codi=$comprador]/telefon[2]"/>
                 <td><xsl:value-of select="$telefono"/></td>
                 <td colspan="3"><xsl:value-of select="$telefono2"/></td>
             </tr>

             <tr class="noVisible">
                 <td colspan="5"/>
             </tr>

             <tr class="header1">
                    <td class="c1">Codi</td>
                    <td class="c2">Unitats</td>
                    <td class="c3">Producte</td>
                    <td class="c4">Quantitat</td>
                    <td class="c5">Preu</td>
             </tr>

             <xsl:for-each select="unitats">
                <tr class="unitats">
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

             <tr class="noVisible">
                 <td colspan="5"/>
             </tr>

             <xsl:variable name="preu" select="sum(unitats/(. * key('producte', @codi)/@preu))"/>
             <xsl:variable name="preuSinIva" select="$preu div(1.21)"/>

             <tr>
                <td colspan="3" class="noVisible"/>
                <td class="dineros text">Base:</td>
                <td class="dineros number"><xsl:value-of select="format-number($preuSinIva, '#.00€')"/></td>
             </tr>

            <tr>
                <td colspan="3" class="noVisible"/>
                <td class="dineros text">Iva:</td>
                <td class="dineros number"><xsl:value-of select="format-number($preu - $preuSinIva, '#.00€')"/></td>
            </tr>

            <tr>
                <td colspan="3" class="noVisible"/>
                <td class="dineros text">Preu Total:</td>
                <td class="dineros number"><xsl:value-of select="format-number($preu, '#.00€')"/></td>
            </tr>

             <tr class="PagoYFirma">
                 <td colspan="2" class="firma"><xsl:value-of select="/celler/clients/client[@codi=$comprador]/nom"/></td>
                 <td>Metodo<br/>de<br/>pago:</td>
                 <xsl:variable name="current-time" select="string(current-dateTime())"/>
                 <xsl:variable name="combined-value" select="number(substring(replace($current-time, '[-T:.]', ''), 10, 3)) + position()"/>
                 <xsl:variable name="random-number" select="if (($combined-value + 1) mod 5 lt 3) then 1 else 2"/>
                 <xsl:if test="$random-number = 1">
                        <td colspan="2" class="cash"/>
                 </xsl:if>
                 <xsl:if test="$random-number = 2">
                        <td colspan="2" class="card"/>
                 </xsl:if>

             </tr>
         </table>
    </xsl:template>

    <xsl:template name="buides">
        <xsl:param name="contador"/>
        <xsl:if test="13 > $contador">
            <tr class="unitats">
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