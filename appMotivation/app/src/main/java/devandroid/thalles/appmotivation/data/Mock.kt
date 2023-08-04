package devandroid.thalles.appmotivation.data

import devandroid.thalles.appmotivation.infra.MotivationConstants
import kotlin.random.Random

class Mock {
    private val infinit = MotivationConstants.FILTER.INFINIT
    private val sunny = MotivationConstants.FILTER.SUN
    private val sentiment = MotivationConstants.FILTER.SENTIMENT

    private val mListPhrase = listOf<Phrase>(

        Phrase("Não sabendo que era impossível, foi lá e fez.", sentiment),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", sentiment),
        Phrase("Quando está mais escuro, vemos mais estrelas!", sentiment),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", sentiment),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", sentiment),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", sentiment),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", sunny),
        Phrase("Você perde todas as chances que você não aproveita.", sunny),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", sunny),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", sunny),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", sunny),
        Phrase("Se você acredita, faz toda a diferença.", sunny),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", sunny) )

    fun getPhrase(value: Int): String {

        val filtered = mListPhrase.filter { it.categoryId == value || value == infinit}
        val index = Random.nextInt(filtered.size)
        return filtered[index].description

    }

}

