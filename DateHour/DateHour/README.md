## Data - Hora

* Data-[hora]local: 
Uso quando o momento exato não tem importancia para outros fusos.
Exemplo:
Data de nascimento : 15/06/2001
Data hora da venda : 13/08/2022 - 13:32(não importa o timezone da hora)

* Data-hora global: 
Uso quando o momento exato importa para outros fusos(horário de inscrição, lives e afins).
Sistemas multi-região - web:

* Quando será o sorteio : 21/08/2022 - 20hrs(horário de São Paulo - nesse caso é passado a hora do local onde será realizado o sorteio).

* Quando o comentairio foi postado: há 17 minutos.

* Quando foi realizada a venda: 13/07/2022 - 15:32(horário de São Paulo)

* Inicio e fim do evento: 21/07/2022 - 14h ás 16h(horário de São Paulo).

# Padrão ISO 8601

<h2>Data-[hora]local:</h2>
[2022/07-21]</br>
[2022-07-21T14:32]</br>
[2022-07-21T14:32:09]</br>
[2022-07-21T14:32.4083]

<h2>Data-hora global:</h2>
[2022-07-21T14:32Z]</br>
[2022-07-21T14:32.25156Z]</br>
[2022-07-21T14:32-03:00] (referencia a horario de SP)


## Operações importantes com data-hora

* Instanciação:
 - (agora) -> Data-hora
 - Texto ISO 8601 -> Data-hora
 - Texto formato customizado -> Data-hora
 - dia, mês, ano,[horário] -> Data-hora


 * Formatação
 - Data-hora -> Texto ISO 8601
 - Data-hora -> Texto formato customizado


## Exemplos de uso de data no JAVA

<h3>Data-hora local</h3>
[LocalDate]- 
{LocalDate d01 = LocalDate.now();} </br>
[LocalDate Time] -{ LocalDateTime d02 = LocalDateTime.now();}

<h3>Data-hora global</h3>
[Instant] - {Instant d03 = Instant.now();}

<h3>Duração</h3>
[Duration]

<h3>Outros</h3>
[ZoneId]</br>
[ChronoUnit]