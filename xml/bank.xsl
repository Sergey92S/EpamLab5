<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">
	<xsl:template match="/">
		<html>
			<body>
				<xsl:for-each select="banks/bank">
				<table border="1">
					<tr>
						<th colspan="3">Depositor's name:</th>
					</tr>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Surname</th>
					</tr>
					<xsl:for-each select="depositor-bank/depositor">
						<tr>
							<td>
								<xsl:value-of select="@id" />
							</td>
							<xsl:for-each select="name">
							<td>
								<xsl:value-of select="@firstname" />
							</td>
							<td>
								<xsl:value-of select="@surname" />
							</td>
							</xsl:for-each>
						</tr>
					</xsl:for-each>
				</table>
				<table border="1">
					<tr>
						<th colspan="7">Bank deposit information:</th>
					</tr>
					<tr>
						<th>ID</th>
						<th>BankName</th>
						<th>Type</th>
						<th>Country</th>
						<th>Profitability</th>
						<th>Timeconstraints</th>
						<th>AccountId</th>
					</tr>
					<xsl:for-each select="depositor-bank/bank-deposits/bank-deposit">
						<tr>
							<td>
								<xsl:value-of select="@id" />
							</td>
							<td>
								<xsl:value-of select="bankname" />
							</td>
							<td>
								<xsl:value-of select="type" />
							</td>
							<td>
								<xsl:value-of select="country" />
							</td>
							<td>
								<xsl:value-of select="profitability" />
							</td>
							<td>
								<xsl:value-of select="timeconstraints" />
							</td>
							<td>
								<xsl:value-of select="accountid" />
							</td>
						</tr>
					</xsl:for-each>
				</table>
				</xsl:for-each>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>