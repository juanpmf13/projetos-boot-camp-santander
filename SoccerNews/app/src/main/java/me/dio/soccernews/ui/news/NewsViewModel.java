package me.dio.soccernews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import me.dio.soccernews.domain.News;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> mNews;

    public NewsViewModel() {
        mNews = new MutableLiveData<>();

        //TODO remover mock de  notícias
        List<News> news = new ArrayList<>();
        news.add(new News("Boa Vista Tem Desfalque Importante ","Você toca uma criatura e estimula sua habilidade de cura " +
                "natural. O alvo recupera 4d8 + 15 pontos de vida. Pela " +
                "duração da magia o alvo recupera 1 ponto de vida no " +
                "início de cada turno dela (10 pontos de vida por minuto)." +
                "Os membro decepados do corpo do alvo (dedos, pernas, " +
                "rabos e assim por diante), se tiver algum, são restaurados " +
                "após 2 minutos. Se você tiver a parte decepada e segura-la contra o topo, a magia, instantaneamente, faz com que " +
                "o membro se grude ao toco."));
        news.add(new News("Boa Vista Vs Flamengo Nessa Segunda","Um relâmpago forma uma linha de 30 metros de " +
                "comprimento e 1,5 metro de largura que é disparado por " +
                "você em uma direção, à sua escolha. Cada criatura na " +
                "linha deve realizar um teste de resistência de Destreza. " +
                "Uma criatura sofre 8d6 de dano elétrico se falhar na " +
                "resistência ou metade desse dano se obtiver sucesso." +
                "O relâmpago incendeia objetos inflamáveis na área " +
                "que não estejam sendo vestidos ou carregados."));
        news.add(new News("Boa Vista Campeão Mundia?","Ao seu toque, todas as maldições afetando uma criatura " +
                "ou objeto terminam. Se o objeto for um item mágico " +
                "amaldiçoado, sua maldição persiste, mas a magia rompe a " +
                "sintonia do portador com o objeto, então permitindo que " +
                "ele o remova ou descarte."));

        mNews.setValue(news);
    }

    public LiveData<List<News>> getNews() {
        return mNews;
    }
}