<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html" version="5.0"/>
    <xsl:template match="celler">
        <html>
            <head>
                <title>Clients</title>
                <link rel="stylesheet" type="text/css" href="celler.css"/>
            </head>
            <body>
                <table>
                    <xsl:apply-templates select="clients/client">
                        <xsl:sort select="nom"/>
                        <xsl:sort select="@codi"/>
                    </xsl:apply-templates>
                </table>


            </body>
        </html>
    </xsl:template>

    <xsl:template match="client">
        <tr>
            <td><xsl:value-of select="@codi"/></td>
            <td><xsl:value-of select="nom"/></td>

            <!-- <xsl:for-each select="telefon">
            <td><xsl:value-of select="current()"/></td>
            </xsl:for-each> -->

            <td><xsl:value-of select="telefon[1]"/></td>
            <td><xsl:value-of select="telefon[2]"/></td>
        </tr>
    </xsl:template>

</xsl:stylesheet>