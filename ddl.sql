CREATE TABLE FICHA_CAMPO
(
  id                      INTEGER not NULL AUTO_INCREMENT,
  muestra                 VARCHAR(255),
  origen_roca             VARCHAR(255),
  unidad_geologica        VARCHAR(255),
  contacto_geologico      VARCHAR(255),
  ubicacion_id            INTEGER,
  estructura_geologica_id INTEGER,
  catalogacion_id         INTEGER,
  PRIMARY KEY (id)
);

CREATE TABLE UBICACION
(
  id        INTEGER not NULL AUTO_INCREMENT,
  fecha     VARCHAR(255),
  escala    VARCHAR(255),
  provincia VARCHAR(255),
  canton    VARCHAR(255),
  sector    VARCHAR(55),
  foto      BLOB,
  PRIMARY KEY (id)
);


# Estructura geologica
CREATE TABLE ESTRUCTURA_GEOLOGICA
(
  id                        INTEGER not NULL AUTO_INCREMENT,
  categoria                 VARCHAR(255),
  subcategoria              VARCHAR(255),
  descripcion               TEXT,
  institucion_generadora    VARCHAR(255),
  estructura_geologica_type VARCHAR(255),

  # SUBTIPOS
  # Falla
  # Campo comun para:estructura_lineal, diaclasa y falla
  rumbo                     FLOAT(4),
  # Campo comun para: estructura_lineal, Estructura_plana, falla, pliegue
  buzamiento                FLOAT(2),
  azimut                    FLOAT,
  clase_falla               VARCHAR(3),
  estado                    VARCHAR(1),
  certeza                   VARCHAR(2),
  escarpe                   VARCHAR(255),
  #   estructura_lineal
  clase_estr_lineal         VARCHAR(2),
  lineacion                 VARCHAR(2),
  #   Estructura_plana
  #   Campo comun para estructura_plana y diaclasa
  buzamiento_intensidad     varchar(1),
  clivaje                   VARCHAR(2),
  estratificacion           VARCHAR(2),
  fotogeologia              VARCHAR(2),
  zona_de_cizalla           VARCHAR(2),
  #  Dique
  clase_dique               VARCHAR(2),
  textura_de_roca           VARCHAR(1),
  # Foliacion
  rocas_metaforicas         VARCHAR(2),
  rocas_igneas              VARCHAR(2),
  #   diaclasa
  direccion                 FLOAT,
  asociacion                VARCHAR(1),
  formacion                 VARCHAR(1),
  diaclasa_clase            VARCHAR(2),
  # Pliegue
  tipo                      VARCHAR(2),
  altura                    float,
  separacion                float,
  posicion                  varchar(1),
  angulo_entre_flancos      varchar(1),
  perfil                    varchar(1),
  sistema                   VARCHAR(1),


  PRIMARY KEY (id)

);
#   CONSTRAINTS
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

# Catalogacion
CREATE TABLE CATALOGACION
(
  id                     INTEGER not NULL AUTO_INCREMENT,
  categoria              VARCHAR(255),
  subcategoria           VARCHAR(255),
  descripcion            TEXT,
  institucion_generadora VARCHAR(255),
  catalogacion_type      VARCHAR(255),

  # SUBTIPOS
  #   alteracion_hidrotermal
  factores               VARCHAR(2),
  procesos               VARCHAR(1),
  alt_hidr_clases        VARCHAR(55),
  #   sitio_fosilifero
  localizacion           VARCHAR(55),
  nombre                 VARCHAR(55),
  densidad               VARCHAR(2),
  era                    VARCHAR(2),
  periodo                VARCHAR(2),
  epoca                  VARCHAR(3),
  piso                   VARCHAR(3),
  # muestra
  naturaleza             VARCHAR(55),
  tipo_muestra           VARCHAR(55),
  consistencia_material  VARCHAR(55),
  codigo                 FLOAT,
  #   sitio campo comun muestra y afloramiento
  sitio                  VARCHAR(55),
  tipo_analisis          VARCHAR(55),
  metodo_analisis        VARCHAR(55),
  nom_metodo_analisis    VARCHAR(55),
  cantidad_muestra       FLOAT,
  observacionies         VARCHAR(255),
  #   fosil
  reino                  VARCHAR(55),
  clase_fosil            VARCHAR(55),
  flora                  VARCHAR(55),
  fauna                  VARCHAR(55),
  tamano                 FLOAT,
  #   afloramiento
  diemension             FLOAT,
  origen_roca            VARCHAR(2),
  tipoRoca               VARCHAR(55),
  #   contacto_geologico
  limite                 VARCHAR(55),
  tipo_contacto          VARCHAR(55),
  certeza                VARCHAR(55),
  #   roca
  tipo                   VARCHAR(55),
  estructura             VARCHAR(55),
  #   deposito_superficial
  clase_deposito         VARCHAR(55),
  #   dominio_litotectonico
  region                 VARCHAR(55),
  PRIMARY KEY (id),
  /*
t - Temperatura
cf - Composición del Fluido
pc - Permeabilidad de la roca
di - Duracción de interacción agua/roca
cr - Composición de la roca
p - Presión
   */
  constraint ck_alt_hidr_factores check (factores in
                                         ('t ', 'cf', 'pc', 'di', 'c', 'p')),
  /*
  d - Depositación directa
  r - Reemplazo
  l - Lixiviación
     */
  constraint ck_alt_hidr_procesos check (procesos in
                                         ('d ', 'r', 'l')),
  /*
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
  /*
e - Excepcional
m - Mediana
b - Baja
      */
  constraint ck_sitio_fos_densidad check (densidad in
                                          ('e ', 'm', 'b')),

  /*
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
                                          'Q1i', 'Q1s', 'Q2'))
);

