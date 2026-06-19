package ar.com.grupoesfera.repartir.steps.grupos;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import ar.com.grupoesfera.repartir.exceptions.TotalNegativoException;
import ar.com.grupoesfera.repartir.model.Grupo;
import ar.com.grupoesfera.repartir.steps.FastCucumberSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

import static org.assertj.core.api.Assertions.assertThat;

public class TotalNoDebeSerNegativoSteps extends FastCucumberSteps {
	private Grupo grupo;
	private boolean error = false;

	@Dado("un grupo con total {int}")
	public void unGrupoConTotal(int total) {
		List<String> miembros = new LinkedList<String>();
		miembros.add("Oscar");

		grupo = new Grupo();
		grupo.setMiembros(miembros);
		grupo.setTotal(BigDecimal.valueOf(total));
	}

	@Cuando("el usuario intenta setear el total en {int}")
	public void elUsuarioIntentaSetearElTotalEn(int total) {
		try {
			this.grupo.setTotal(BigDecimal.valueOf(total));
		} catch (TotalNegativoException e) {
			this.error = true;
		}
	}

	@Cuando("el usuario intenta agregar un gasto de {int}")
	public void elUsuarioIntentaAgregarUnGastoDe(int gasto) {
		try {
			this.grupo.agregarGasto(BigDecimal.valueOf(gasto));
		} catch (TotalNegativoException e) {
			this.error = true;
		}
	}

	@Entonces("el total del grupo será {int}")
	public void elTotalDelGrupoSera(int total) {
		assertThat(this.grupo.getTotal()).isEqualTo(BigDecimal.valueOf(total));
	}

	@Y("se notifica el error")
	public void seNotificaElError() {
		assertThat(this.error).isTrue();
	}
}
