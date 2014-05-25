package fr.cances.steve.annuaire.spring.model.service.impl;


/**
 * FIXME Tests avec DAOs mockés.
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
// @RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(classes = { TestPersistenceConfig.class })
public class ServiceAnnuaireImplTest {// extends AbstractRepositoryJpaTest {

    // @Autowired
    // private ServiceAnnuaire serviceAnnuaire;
    //
    // @Autowired
    // private ServiceAnnuaireAdmin serviceAnnuaireAdmin;
    //
    // public Long idPersonne;
    //
    // @Before
    // public void before() {
    // this.truncateSchemaPublic();
    // PersonneVo personneVo = new PersonneVo();
    // personneVo.setNom("Cancès");
    // personneVo.setPrenom("Steve");
    // personneVo = this.serviceAnnuaireAdmin.createPersonne(personneVo);
    // this.idPersonne = personneVo.getId();
    // personneVo = new PersonneVo();
    // personneVo.setNom("Jobs");
    // personneVo.setPrenom("Steve");
    // this.serviceAnnuaireAdmin.createPersonne(personneVo);
    // }
    //
    // @Test
    // public void testGetAllPersonnes() {
    // Collection<PersonneVo> personnesVo =
    // this.serviceAnnuaire.getAllPersonnes();
    // assertEquals(2, personnesVo.size());
    // }
    //
    // @Test
    // public void testGetPersonne() {
    // assertEquals(2, this.serviceAnnuaire.getAllPersonnes().size());
    // PersonneVo personneVo = this.serviceAnnuaire.getPersonne(idPersonne);
    // assertEquals("Steve", personneVo.getPrenom());
    // assertEquals("Cancès", personneVo.getNom());
    // }
    //
    // @Test
    // public void testFindPersonnesLikePrenomOrNom() {
    // assertEquals(2,
    // this.serviceAnnuaire.findPersonnesLikePrenomOrNom("Steve").size());
    // assertEquals(2,
    // this.serviceAnnuaire.findPersonnesLikePrenomOrNom("eve").size());
    // assertEquals(1,
    // this.serviceAnnuaire.findPersonnesLikePrenomOrNom("Jobs").size());
    // assertEquals(1,
    // this.serviceAnnuaire.findPersonnesLikePrenomOrNom("Jo").size());
    // }
}
