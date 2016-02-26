package br.com.distrowatch;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class DistroWatch {

	static DistroWatch distroWatch;

	public static DistroWatch getInstance() {

		if (distroWatch == null) {
			distroWatch = new DistroWatch();
		}

		return distroWatch;
	}

	ObjectContainer distribution = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "../distribution.db4o");

	public Distribuicao buscaPorDistribuicao(String nomeDistribuicao) {
		Query query = distribution.query();
		query.constrain(Distribuicao.class);
		ObjectSet<Distribuicao> allDistribuicao = query.execute();

		for (Distribuicao distribuicao : allDistribuicao) {
			if ((distribuicao.getDistribuicao().toUpperCase()).contains(nomeDistribuicao.toUpperCase())) {
				return distribuicao;
			}

		}

		return null;
	}

	public void adicionarDistribuicao(Distribuicao distribuicao) {
		distribution.store(distribuicao);
	}

	public void deletarDistribuicao(ObjectContainer distribuicao) {

	}
}
