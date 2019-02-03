create table ficha_campo
(
  id                            SERIAL
    primary key,
  datum                         varchar(255),
  escala                        varchar(255),
  proyecto                      varchar(255),
  datos_ubicacion               text,
  descrita_por                  varchar(255),
  ubicacion_id                  int,
  nomenclatura_unidad_geologica varchar(2),
  # Contacto geologico
  tipo_contacto_geo             varchar(2),
  limite_contacto_geo           varchar(2),
  certeza_contacto_geo          varchar(2),
  # Roca
  origen_roca                   varchar(2),
  estructura_roca               varchar(2),
  # Estructuras
  pliegue_id                    int,
  estructura_lineal_id          int,
  estructura_planar_id          int,
  # Catalogaciones
  muestra_id                    int,
  contacto_geologico_id         int,
  afloramiento_id               int,
  roca_id                       int,
  # Users
  user_id int
);

create table user
(
  id SERIAL
    primary key,
  first_name varchar(255),
  last_name varchar(255),
  username varchar(255),
  password varchar(255),
  roles varchar(255)
);

create table ubicacion
(
  id        SERIAL
    primary key,
  fecha     varchar(255),
  provincia varchar(255),
  canton    varchar(255),
  sector    varchar(55),
  escala    varchar(255),
  foto      blob
);

# Catalogaciones

create table muestra
(
  id                           SERIAL
    primary key,
  naturaleza                   varchar(255),
  tipo                         varchar(255),
  consistencia_material        varchar(2),
  codigo                       long,
  sitio                        varchar(2),
  tipo_analisis                varchar(2),
  metodo_analisis              varchar(2),
  nomenclatura_metodo_analisis varchar(2),
  cantidad_muestra             float,
  observaciones                varchar(2)
);

create table afloramiento
(
  id        SERIAL
    primary key,
  dimension varchar(2),
  origen    varchar(2),
  tipo_roca varchar(2),
  sitio     varchar(2)
);

# Estructuras geologicas
create table estructura_planar
(
  id                    SERIAL
    primary key,
  buzamiento_intensidad varchar(2),
  azimut                float,
  clivaje               varchar(2),
  estratificacion       varchar(2),
  fotogeologia          varchar(2),
  zona_de_cizalla       varchar(2),
  # foliacion
  rocas_metaforicas     varchar(2),
  rocas_igneas          varchar(2)
);

create table estructura_lineal
(
  id                SERIAL
    primary key,
  rumbo             float,
  clase_estr_lineal varchar(2),
  lineacion         varchar(2),
  # diaclasa
  direccion         float,
  buzamiento        varchar(2),
  asociacion        varchar(2),
  formacion         varchar(2),
  diaclasa_clase    varchar(2)
);

create table pliegue
(
  id                   SERIAL
    primary key,
  rumbo                float,
  buzamiento           float,
  tipo                 varchar(2),
  altura               float,
  separacion           float,
  posicion             varchar(2),
  angulo_entre_flancos varchar(2),
  perfil               varchar(2),
  sistema              varchar(2)
);


  /* DONE
t - Temperatura
cf - Composición del Fluido
pc - Permeabilidad de la roca
di - Duracción de interacción agua/roca
cr - Composición de la roca
p - Presión
   */
  constraint ck_alt_hidr_factores check (factores in
                                         ('t ', 'cf', 'pc', 'di', 'c', 'p')),
  /* DONE
  d - Depositación directa
  r - Reemplazo
  l - Lixiviación
     */
  constraint ck_alt_hidr_procesos check (procesos in
                                         ('d ', 'r', 'l')),
  /* DONE
  sf - Silicificación
  st - Sericitización
  ag - Argilitización
  cl - Cloritización
  ep - Epidotización
  ac - Actinolización
  pl - Propilítica
  ai - Argílica Intermedia
  cs - Sericítica o cuarzo-sericítica
  aa - Argílica avanzada
  ps - Potásica
  sc - Sódico-cálcica
  sk - Skarn
  gs - Greissen
     */
  constraint ck_alt_hidr_clases check (alt_hidr_clases in
                                       ('sf ', 'st', 'ag', 'cl', 'ep', 'ac', 'pl', 'ai', 'cs', 'aa', 'ps', 'sc', 'sk',
                                        'gs')),
  /* DONE
e - Excepcional
m - Mediana
b - Baja
      */
  constraint ck_sitio_fos_densidad check (densidad in
                                          ('e ', 'm', 'b')),

  /* DONE
 p - Paleozóico
 m - Mesozóico
 c - Cenozóico
       */
  constraint ck_sitio_fos_era check (era in
                                     ('PZ ', 'MZ', 'CZ')),
  /*
ε - Cámbrico
O - Ordovícico
S - Silúrico
D - Devónico
C1 - Carbonífero Misisipiense
C2 - Carbonífero Pensilvaniense
P - Pérmico
T - Triásico
J - Jurásico
K - Cretácico
E - Terciario Paleógeno
N - Terciario Neógeno
Q - Cuaternario
   */
  constraint ck_sitio_fos_periodo check (periodo in
                                         ('ε ', 'O', 'S', 'D', 'C1', 'C2', 'P', 'T', 'J', 'K', 'E', 'N', 'Q')),
  /*
  ε1 - Cámbrico Inferior
  ε2 - Cámbrico Medio
  ε3 - Cámbrico Superior
  O1 - Ordovícico Inferior
  O2 - Ordovícico Medio
  O3 - Ordovícico Superior
  S1 - Silúrico Inferior
  S2 - Silúrico Superior
  D1 - Devónico Inferior
  D2 - Devónico Medio
  D3 - Devónico Superior
  C1 - Carbonífero Misisipiense Inferior
  C2 - Carbonífero Pensilvianense Superior
  P1 - Pérmico Inferior
  P2 - Pérmico Superior
  T1 - Triásico Inferior
  T2 - Triásico Medio
  T3 - Triásico Superior
  J1 - Jurásico Inferior Lías
  J2 - Jurásico Medio Dogger
  J3 - Jurásico Superior Malm
  K1n - Cretácico Inferior Neocomiense
  K1 - Cretácico Inferior
  K2 - Cretácico Superior
  K2s - Cretácico Superior Senonense
  E1i - Paleoceno Inferior
  E1s - Paleoceno Superior
  E2i - Eoceno Inferior
  E2m - Eoceno Medio
  E2s - Eoceno Superior
  E3i - Oligoceno Inferior
  E3s - Oligoceno Superior
  N1i - Mioceno Inferior
  N1m - Mioceno Medio
  N1s - Mioceno Superior
  N2i - Plioceno Inferior
  N2s - Plioceno Superior
  Q1i - Pleistoceno Inferior
  Q1s - Pleistoceno Superior
  Q2 - Holoceno
     */
  constraint ck_sitio_fos_epoca check (epoca in
                                       ('ε1 ', 'ε2', 'ε3', 'O1', 'O2', 'O3', 'S1', 'S2', 'D1', 'D2', 'D3', 'C1', 'C2',
                                        'P1', 'P2', 'T1', 'T2', 'T3', 'J1', 'J2', 'J3', 'K1n', 'K1', 'K2', 'K2s', 'E1i',
                                        'E1s', 'E2i', 'E2m', 'E2s', 'E3i', 'E3s', 'N1i', 'N1m', 'N1s', 'N2i', 'N2s'
                                          'Q1i', 'Q1s', 'Q2')),

  /*
  s1 - Georgiense
  s2 - Acadiense
  s3 - Franconiense, Posdaniense
  s4 - Termadociense
  d1 - Arenigiense
  d2 - Llanvirniense
  d3 - Llandeilaniense
  d4 - Caradociense
  d5 - Ashgillianiense
  d6 - Llandoveriainense
  d7 - Wenlockiniense
  c1 - Ludlovianiense
  c2 - Pridolianiense
  c3 - Gedinnianiense
  c4 - Sigenianiense
  c5 - Emisaniense
  c6 - Eifelianiense
  c7 - Givetianiense
  p1 - Frasnianiense
  p2 - Famennianiense
  p3 - Tournaisianiense
  p4 - Viseaniense
  p5 - Serpujovianiense
  p6 - Bashkirianiense
  p7 - Moscoviense
  t1 - Kasinoviniense
  t2 - Gzelianiense
  t3 - Sakmarianiense
  t4 - Asselianiense
  t5 - Artinskianiense
  l1 - Kungurianiense
  l2 - Ufimianiense
  l3 - Kazarianiense
  l4 - Tatarianiense
  j1 - Scythaniense
  j2 - Anisiense
  j3 - Ladiniense
  j4 - Karniense
  j5 - Noriense
  j6 - Hettangiense
  j7 - Sinemuriense
  b1 - Pliensbachiense
  b2 - Toarciense
  b3 - Aaleniense
  b4 - Bajocense
  b5 - Bathoniense
  b6 - Calloviense
  k1 - Oxfordiense
  k2 - Kimmeridgiense
  k3 - Portlandiense
  k4 - Berriasiense
  k5 - Valanginiense
  k6 - Hauteriviense
  e1 - Barremiense
  e2 - Aptiense
  e3 - Albiense
  e4 - Cenomaniense
  e5 - Turoniense
  e6 - Coniaciense
  e7 - Santoniense
  e8 - Campaniense
  e9 - Maastrictiense
  n1 - Daniense
  n2 - Selandiense Unnmediense
  n3 - Thanetiense
  n4 - Ypresiense
  n5 - Luteciense
  n6 - Bartoniense
  n7 - Priaboniense
  n8 - Rupeliense
  n9 - Chattiense
  a - Aquitaniense
  b - Burdigaliense
  c - Langhiniense
  d - Serravaliense
  e - Tortoniense
  f - Messiniense Pontiense
  g - Zancliamiense
  h - Piacenziense Villafranquiense
  i - Emiliense
  j - Calabriense
  k - Siciliense
  l - Milazziense
  m - Tyrreniense
  n - Versiliense

   */
  constraint ck_sitio_fos_piso check (piso in
                                      ('s1 ', 's2', 's3', 's4', 'd1', 'd2', 'd3', 'd4', 'd5', 'd6', 'd7', 'c1', 'c2',
                                       'c3', 'c4', 'c5', 'c6', 'c7', 'p1', 'p2', 'p3', 'p4', 'p5', 'p6', 'p7', 't1',
                                       't2', 't3', 't4', 't5', 'l1', 'l2', 'l3', 'l4', 'j1', 'j2', 'j3'
                                         'j4', 'j5', 'j6', 'j7', 'b1', 'b2', 'b3', 'b4', 'b5', 'b6', 'k1', 'k2', 'k3',
                                       'k4', 'k5', 'k6', 'e1', 'e2', 'e4', 'e5', 'e6', 'e', 'e8', 'e9', 'n1', 'n2',
                                       'n2', 'e3', 'e4', 'e5', 'e6', 'e7', 'e8', 'e9', 'n1', 'n2', 'n3', 'n4', 'n5',
                                       'n6', 'n7', 'n8', 'n9', 'n7', 'a', 'b', 'c', 'd', 'e', 'f', 'e', 'g', 'h', 'i',
                                       'j', 'k', 'l', 'm', 'n')),
  /*
  r - Roca
  s - Suelo
  a - Agua
  d - Sedimentos
         */
  constraint ck_muestra_naturaleza check (naturaleza in
                                          ('r ', 's', 'a', 'd')),
  /*
  n - No consolidado
  m - Moderadamente consolidado
  f Fuertemente consolidado
           */
  constraint ck_muestra_consistencia_material check (consistencia_material in
                                                     ('n ', 'm', 'f')),
  /*
g - Geocronológico
q - Geoquímico
m - Micropaleontológico
p - Paleontológico
r - Petrográfico
n - Metalúrgico
         */
  constraint ck_muestra_tipo_analisis check (tipo_analisis in
                                             ('g ', 'q', 'm', 'p', 'r', 'n')),
  /*
AAS - Espectrofotometría Absorción Atómica
COP - Copelación
ICP - Plasma Inductivamente Acoplado
XRF - Espectrometía por Fluorescencia de rayos X
FES - Espectrometria por emisión de flama
EPMA - Microsonda electrónica de Barrido
EIR - Espectroscopía infraroja
COL - Colorimetría
DTA - Análisis Térmico Diferencial
VH - Vía húmeda
DE - Destilación
TM - Termometría
SG - Determinación de gravedad específica
SEF - Separación Mineral
GRF - Gravimetría
GR - Granulometria
MLT - Microscopía de luz transmitida
MLR - Microscopía de luz reflejada
FM - Fotomicrografía
IF - Inclusiones Fluidas
FL - Flotación por espuma
HM - Hidrometalurgia
CN - Cianuración
SEM - Separación Magnética
   */

  constraint ck_muestra_metodo_analisis check (metodo_analisis in
                                               ('AAS ', 'COP', 'ICP', 'XRF', 'FES', 'EPMA', 'EIR', 'COL', 'DTA', 'VH',
                                                'DE', 'TM',
                                                'SG', 'SEF', 'GRF', 'GR', 'MLT', 'MLR', 'FM', 'IF', 'FL', 'HM', 'CN',
                                                'SEM')),
  /*
  a - Animalía
  p - Plantae
   */
  constraint ck_fosil_reino check (reino in ('a ', 'p')),
  /*
 v - Vertebrados
 i - Invertebrados
 t - Troncos/Plantas
 f Icnofósiles
   */

  constraint ck_fosil_clase_fosil check (clase_fosil in ('v ', 'i', 't', 'f')),
  /*
  a - Angiospermas
  g - Gimnospermas
  l - Algas
  d - Diatomeas
  h - Helechos
  p - Palinomorfos
   */
  constraint ck_fosil_clase_flora check (flora in ('a', 'g', 'l', 'd', 'h', 'p')),
  /*
  bi - Bivalvos
  ga - Gasterópodos
  an - Ammonoideos
  bq - Braquiópodos
  eq - Equinoideos
  tb - Trilobites
  bz - Briozoos
  cr - Corales
  es - Esponjas
  at - Artrópodos
  pc - Peces
  af - Anfibios
  rt - Reptiles
  av - Aves
  mm - Mamíferos
  ic - Insectos
  hm - Homínidos
  fm - Foraminíferos
  cd - Conodontos
  rd - Radiolarios
  ct - Cocolitóforos
   */

  constraint ck_fosil_clase_fauna check (fauna in
                                         ('bi', 'ga', 'an', 'bq', 'eq', 'tb', 'bz', 'cr', 'es', 'at', 'pc', 'af', 'rt',
                                          'av', 'mm', 'ic', 'hm', 'fm', 'cd', 'rd', 'ct')),
  /*
  u - Microfósil
  m - Macrofósil
     */
  constraint ck_fosil_reino check (reino in ('u', 'm')),
  /*
  p - Pequeño
  m - Mediano
  g - Grande
   */
  constraint ck_afloramiento_diemension check (diemension in ('p', 'm', 'g')),

  /*
 mi - Magmática o Ígnea
 mp - Magmática Intrusiva o Plutónica
 mf - Magmática Hipoabisal o Filoniana
 mv - Magmática Efusiva o Volcánica
 mm - Metamórfica
 sm - Sedimentaria
 sc - Sedimentaria Clástica o dentrítica
 sq - Sedimentaria Química
 og - Sedimentaria Organógenas o Bioquímica
 sp - Sedimentaria Piroclástica

   */

  constraint ck_afloramiento_origen_roca check (origen_roca in
                                                ('mi', 'mp', 'mf', 'mv', 'mm', 'sm', 'sc', 'sq', 'og', 'sp')),

  /*
gf - Granito con Feldespatos alcalinos
gr - Granito
gd - Granodiorita
tn - Tonalita
sn - Sienita
sf - Sienita con Feldespatos alcalinos
mz - Monzonita
dr - Diorita
ge - Grabo eufótido
go - Grabo olivínico
gp - Grabo con ortopiroxeno
at - Anortosita
sf - Sienita con Feldespatoides
px - Piroxenita
hb - Hornblendita
dn - Dunita
lz - Lerzolita
pc - Peridotita Cumulítica
pg - Peridotita granatífera
km - Kimberlita
gu - Gricuaíta
ex - Esexita
pg - Pórfido Granítico
gn - Granófiro
pd - Porfirita diorítica
db - Diabasa
pg - Pegmatita
al - Aplita
lp - Lamprófido
ra - Riolita Alcalina
rl - Riolita
pu - Pórfido cuarcífero
dc - Dacita
lt - Latita
tq - Traquita
as - Andesita
bl - Basalto
fl - Fonolita
tf - Tefrita
bs - Basanita
nl - Nefelinitas
lu - Leucititas
mt - Melilititas
cb - Carbonatitas
os - Obsidiana
pp - Piedra Pómez
cc - Cuarcita
fa - Filita
mq - Micasquisto
cq - Cloirtosquisto
gi - Gneis
pn - Prasinita
tq - Talcosquisto
sa - Serpentina
st - Serpentinita
eg - Esquisto glaucofánico
ae - Anfibolita epidótica
ab - Anfibolita
gu - Granulita
eg - Eclogita
co - Calcosquisto
ri - Rodingita
pm - Pizarra mosqueada
cu - Cornubianita
qa - Esquisto calcáreo
sn - Skarn
eq - Embrequita
ax - Anatexita
bu - Nebulita
ag - Agmatita
ma - Mármol
cm - Conglomerado
pu - Pudinga
be - Brecha
of - Oficalcita
as - Arenisca
ar - Arcosa
gv - Grauvaca
al - Argilita
mg - Marga
ml - Milonita
tv - Travertino
yo - Yeso
ah - Anhidrita
co - Caliza pisolítica
as - Argilita silícea
nm - Nódula de maganeso
cf - Caliza fosilífera
zc - Caliza compacta
dm - Dolomía
ci - Carniola
di - Diatomita
sr - Sílex y Radiolaritas
ff - Fosforita
hp - Hierro de los pantanos
ta - Turba
at - Antracita
bv - Bomba volcánica
ib - Ignimbrita
tp - Toba porfírica
tc - Toba cristalina
   */
  constraint ck_afloramiento_tipo_roca check (tipo_roca in
                                              ('gf', 'gr', 'gd', 'tn', 'sn', 'sf', 'mz', 'dr', 'ge', 'go', 'gp', 'at',
                                               'sf', 'px', 'hb', 'dn', 'lz', 'pc', 'pg', 'km', 'gu', 'ex', 'pg', 'gn',
                                               'pd', 'db', 'pg', 'al', 'lp', 'ra', 'rl', 'pu', 'dc', 'lt', 'tq', 'as',
                                               'bl', 'fl', 'tf', 'bs', 'nl', 'lu', 'mt', 'cb', 'os', 'pp', 'cc', 'fa',
                                               'mq', 'cq', 'gi', 'pn', 'tq', 'sa', 'st', 'eg', 'ae', 'ab', 'gu', 'eg',
                                               'co', 'ri', 'pm', 'cu', 'qa', 'sn', 'eq', 'ax', 'bu', 'ag', 'ma', 'cm',
                                               'pu', 'be', 'of', 'as', 'ar', 'gv', 'al', 'mg', 'ml', 'tv', 'yo', 'ah',
                                               'co', 'as', 'nm', 'cf', 'zc', 'dm', 'ci', 'di', 'sr', 'ff', 'hp', 'ta',
                                               'at', 'bv', 'ib', 'tp', 'tc')),

  /*
 f - Fallado
 c - Conforme
 d - Discordancia angular
 e - Discordancia erosiva o disconformidad
 i - Inconformidad
 p - Paraconformidad
 t - Trancisional
 s - Depósito superficial
 v - Intrusivo
 u - Cubierto
 y - Desconocido

   */
  constraint ck_contacto_geologico_tipo_contacto check (tipo_contacto in
                                                        ('f ', 'c', 'd', 'e', 'i', 'p', 't', 's', 'v', 'u', 'y')),

  /*
  fo - Falla Observada
  fi - Falla Inferida
  fc - Falla Cubierta
  co - Contacto Observado
  ci - Contacto Inferido
  cf - Contacto por fotografía
  cc - Contacto por facies
   */
  constraint ck_contacto_geologico_limite check (limite in
                                                 ('fo ', 'fi', 'fc', 'co', 'ci', 'cf', 'cc')),
  /*
  i - Inferida
  o - Observada
  c - Contacto por fotografía
   */
  constraint ck_contacto_geologico_certeza check (certeza in
                                                  ('i ', 'o', 'c')),
  /*
  b - Bandeada
  c - Cizallada
  o - Columnar
  a - En almohadilla
  e - Estratificada
  f -  Fluidal
  u - Foliada
  m - Masiva
   */

  constraint ck_roca_estructura check (estructura in
                                       ('b ', 'c', 'o', 'a', 'e', 'f', 'u', 'm')),
  /*
  c - Coluvial
  a - Aluvial
  l - Lacustre
  p - Playa
  g - Glaciar
  e - Eólico
  v - Evaporítico
  i - Eluvial
  t - Terraza
   */
  constraint ck_deposito_superficial_clase_deposito check (clase_deposito in
                                                           ('c', 'a', 'l', 'p', 'g', 'e', 'v', 'i', 't')),
  /*
  tl - Terreno Loja
  mt - Macizo Tahuín
  co - Cuenca Oriental-Macizo Oriental
  ca - Cuenca Alamor
  dz - Dominio Zamora
  tc - Terreno Chaucha
  tp - Terreno Pallatanga-Piñón
   */
  constraint ck_dominio_litotectonico_region check (region in
                                                    ('tl', 'mt', 'co', 'ca', 'dz', 'tc', 'tp'))
);


/* Constraints
   Estructuras geologicas
*/

ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
 no - Normal
 in - Inversa
 dba - De Bajo ángulo
 dca - De Cabalgamiento
 tr - Transcurrente
 trd - Transcurrente dextral
 trs - Transcurrente sinextral
 ddb - De Desplazamiento de buzamiento
 ddo - De Desplazamiento oblicuo
 ddp - De Despegue
 lis - Lístrica
 des - Desconocida
 */
  add constraint ck_falla_clase check (clase_falla in
                                       ('no', 'in', 'dba', 'dca', 'tr', 'trd', 'trs', 'ddb', 'ddo', 'ddp', 'lis',
                                        'des'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
    a - Activa
    i - Inactiva
    */
  add constraint ck_falla_estado check (estado in
                                        ('a', 'i'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
    in - Inferida
    ob - Observada
    fg -Por fotografía
     */
  add constraint ck_falla_certeza check (certeza in
                                         ('in', 'ob', 'fg'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
    is - Intersección
    cn - Crenulación
    eg - Elongación
    em - Elongación mineral
    bd - Boudinage
    cl - Columnar
    et - Estría
    sm - Sedimentaria
    */
  add constraint ck_estr_lineal_clase check (clase_estr_lineal in
                                             ('is', 'cn', 'eg', 'em', 'bd', 'cl', 'et', 'sm'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
  ic - Inclinado
  ho - Horizontal
  vt - Vertical
   */
  add constraint ck_estr_lineal_lineacion check (lineacion in
                                                 ('ic', 'ho', 'vt'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
     s - Suave
     m - Mediano
     f - Fuerte
      */
  add constraint ck_buzamiento_intensidad check (buzamiento_intensidad in
                                                 ('s', 'm', 'f'));

ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
  ce - Clivaje espaciado
  cp - Clivaje penetrativo
  cf - Clivaje de fractura
  ci - Clivaje pizarroso
  cc - Clivaje crenulado
  cs - Clivaje de solución
  */
  add constraint ck_estr_plana_clivaje check (clivaje in
                                              ('ce', 'cp', 'cf', 'ci', 'cc', 'cs'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
   cl - Capa inclinada
   ch - Capa horizontal
   cv - Capa vertical
   ci - Capa invertida
   */
  add constraint ck_estr_plana_estratificacion check (estratificacion in
                                                      ('cl', 'ch', 'cv', 'ci'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
    ii - Inclinación Indeterminada
    sh - Superficie Horizontal
    sv - Superficie Vertical
    in - Inclinación indeterminada invertida
       */
  add constraint ck_estr_plana_fotogeologia check (fotogeologia in
                                                   ('ii', 'sh', 'sv', 'in'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
    zm - Zonas miloniticas
    zb - Zona de brechas
    in - Inclinada
    cz - Cizalla
    */
  add constraint ck_estr_plana_zona_de_cizalla check (zona_de_cizalla in
                                                      ('zm', 'zb', 'in', 'cz'));

ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
     ic - Inclinado
     ho - Horizontal
     vt - Vertical
      */
  add constraint ck_dique_clase_dique check (clase_dique in
                                             ('ic', 'ho', 'vt'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
    a - Textura_de_roca
    i - Para porifidica
    */
  add constraint ck_dique_textura_de_roca check (textura_de_roca in
                                                 ('a', 'i'));

ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
   ic - Inclinado
   ho - Horizontal
   vt - Vertical
    */
  add constraint ck_foliacion_rocas_metaforicas check (rocas_metaforicas in
                                                       ('ic', 'ho', 'vt'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
     ic - Inclinado
     ho - Horizontal
     vt - Vertical
      */
  add constraint ck_foliacion_rocas_igneas check (rocas_igneas in
                                                  ('ic', 'ho', 'vt'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
    a - sistema paralelas
    i - diaclasas que se cortan
    */
  add constraint ck_diaclasa_asociacion check (asociacion in
                                               ('a', 'i'));


ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
  d - Deshidratación
  e - Enfriamiento
  r - Recristalización
      */
  add constraint ck_diaclasa_formacion check (formacion in
                                              ('d', 'e', 'r'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
       ic - Inclinado
       ho - Horizontal
       vt - Vertical
        */
  add constraint ck_diaclasa_clase check (diaclasa_clase in
                                          ('ic', 'ho', 'vt'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
  af - Antiforme
  sf - Sinforme
  nt - Neutro
  ac - Anticlinal
  sc - Sinclinal
  mc - Monoclinal
       */
  add constraint ck_pliegue_tipo check (tipo in
                                        ('af', 'sf', 'nt', 'ac', 'sc', 'mc'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
    p - Parado
    i - Inclinado
    r - Recumbente
    s - Sobreplegado
           */
  add constraint ck_pliegue_posicion check (posicion in
                                            ('p', 'i', 'r', 's'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
  l - Leve
  a - Abierto
  c - Cerrado
  p - Apretado
  i - Isoclinal
             */
  add constraint ck_pliegue_angulo_entre_flancos check (angulo_entre_flancos in
                                                        ('l', 'a', 'c', 'p', 'i'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
p - Paralelo (Concéntrico)
s - Similar
a - En acordeón (Chevron)
   */
  add constraint ck_pliegue_perfil check (perfil in
                                          ('p', 's', 'a'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
    s - Simétricos
    a - Asimétricos
    p - Parásitos (Satélites)
    u - Armonicos
    d - Desarmónicos
    c - Conjugados
    l - Policlinales
           */
  add constraint ck_pliegue_sistema check (sistema in
                                           ('s', 'a', 'p', 'u', 'd', 'c', 'l'));