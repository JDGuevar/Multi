<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html" version="5.0"/>
    <xsl:template match="celler">
        <html>
            <head>
                <title>Productes</title>
                <link rel="stylesheet" type="text/css" href="celler.css"/>
            </head>
            <body>
                <table>
                    <xsl:apply-templates select="productes/producte"/>
                </table>


            </body>
        </html>
    </xsl:template>

    <xsl:template match="producte">
        <tr>
            <td><xsl:value-of select="@codi"/></td>
            <td><xsl:value-of select="current()"/></td>
            <td><xsl:value-of select="@preu"/>€</td>
        </tr>
    </xsl:template>

</xsl:stylesheet>