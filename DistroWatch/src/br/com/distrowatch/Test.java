package br.com.distrowatch;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.json.JSONException;

public class Test {

	static Distribuicao distribuicao = null;

	public static void main(String[] args) throws JSONException {

		initializeModel("ubuntu");
		initializeModel("mint");
		Rest rest = new Rest(distribuicao);
		rest.makeRoute();

	}

	public static void initializeModel(String versao) {

		LinkedHashMap<String, String> dados = Raspagem.getDadosDistroWatch(versao);
		LinkedHashMap<String, String> cabecalho = Raspagem.getCabecalhoDistroWatch();
		
		Especificacao spec = new Especificacao();
		spec.setTipoSo(cabecalho.get("OS Type"));
		spec.setBaseadoEm(cabecalho.get("Based on:"));
		spec.setOrigem(cabecalho.get("Origin"));
		spec.setArquitetura(cabecalho.get("Architecture"));
		distribuicao = new Distribuicao(spec);

		distribuicao.setDistribuicao(dados.get("Distribution").toString());
		distribuicao.setPagInicial(dados.get("Home Page").toString());
		distribuicao.setListaEmails(dados.get("Mailing Lists").toString());
		distribuicao.setForuns(dados.get("User Forums").toString());
		distribuicao.setForunsAlternativos(dados.get("Alternative User Forums").toString());
		distribuicao.setDocumentacao(dados.get("Documentation").toString());
		distribuicao.setScreenshots(dados.get("Screenshots").toString());
		distribuicao.setScreenCast(dados.get("Screencasts").toString());
		distribuicao.setDownload(dados.get("Download Mirrors").toString());
		distribuicao.setBugTracker(dados.get("Bug Tracker").toString());
		distribuicao.setSitesRelacionados(dados.get("Related Websites").toString());
		distribuicao.setRevisoes(dados.get("Reviews").toString());
		distribuicao.setOndeComprar(dados.get("Where To Buy").toString());

		DistroWatch.getInstance().adicionarDistribuicao(distribuicao);

	}

}
