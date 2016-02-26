package br.com.distrowatch;

public class Distribuicao {

	private String distribuicao;
	private String pagInicial;
	private String foruns;
	private String documentacao;
	private String sitesRelacionados;
	private String listaEmails;
	private String forunsAlternativos;
	private String screenshots;
	private String screenCast;
	private String download;
	private String bugTracker;	
	private String revisoes;
	private String ondeComprar;
	private Especificacao spec;

	public Distribuicao(Especificacao spec)
	{
		this.spec = spec;
	}
	public String getDistribuicao() {
		return distribuicao;
	}

	public void setDistribuicao(String distribuicao) {
		this.distribuicao = distribuicao;
	}

	public String getPagInicial() {
		return pagInicial;
	}

	public void setPagInicial(String pagInicial) {
		this.pagInicial = pagInicial;
	}

	public String getForuns() {
		return foruns;
	}

	public void setForuns(String foruns) {
		this.foruns = foruns;
	}

	public String getDocumentacao() {
		return documentacao;
	}

	public void setDocumentacao(String documentacao) {
		this.documentacao = documentacao;
	}

	public Especificacao getSpec() {
		return spec;
	}

	public void setSpec(Especificacao spec) {
		this.spec = spec;
	}
	public String getListaEmails() {
		return listaEmails;
	}
	public void setListaEmails(String listaEmails) {
		this.listaEmails = listaEmails;
	}
	public String getForunsAlternativos() {
		return forunsAlternativos;
	}
	public void setForunsAlternativos(String forunsAlternativos) {
		this.forunsAlternativos = forunsAlternativos;
	}
	public String getScreenshots() {
		return screenshots;
	}
	public void setScreenshots(String screenshots) {
		this.screenshots = screenshots;
	}
	public String getScreenCast() {
		return screenCast;
	}
	public void setScreenCast(String screenCast) {
		this.screenCast = screenCast;
	}
	public String getDownload() {
		return download;
	}
	public void setDownload(String download) {
		this.download = download;
	}
	public String getBugTracker() {
		return bugTracker;
	}
	public void setBugTracker(String bugTracker) {
		this.bugTracker = bugTracker;
	}
	public String getSitesRelacionados() {
		return sitesRelacionados;
	}
	public void setSitesRelacionados(String sitesRelacionados) {
		this.sitesRelacionados = sitesRelacionados;
	}
	public String getRevisoes() {
		return revisoes;
	}
	public void setRevisoes(String revisoes) {
		this.revisoes = revisoes;
	}
	public String getOndeComprar() {
		return ondeComprar;
	}
	public void setOndeComprar(String ondeComprar) {
		this.ondeComprar = ondeComprar;
	}
}
