package pt.reditus.pocsiops.services;

import java.io.File;
import java.util.Collection;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;

import pt.reditus.pocsiops.core.Operators;
import pt.reditus.pocsiops.data.Constants;
import pt.reditus.pocsiops.data.HibernateUtils;
import pt.reditus.pocsiops.response.ResponseOperator;
import pt.reditus.pocsiops.response.ResponseOperatorColl;
import pt.reditus.pocsiops.request.FullSaveOperator;

@Stateless
@Path("/Operators")
public class OperatorsFacadeREST {
	

	static Logger log = Logger.getLogger(
			OperatorsFacadeREST.class.getName());

	@POST
	@Path("/FullSaveOperator")
	@Consumes({ "application/xml", "application/json" })
	@Produces("application/json")
	public ResponseOperator FullSaveOperator(FullSaveOperator pRequest) {
		log.debug("BEGIN--FullSaveActivity pRequest: " + pRequest.toString());
		Session hbSession = null;
		ResponseOperator mRes = new ResponseOperator();
		Operators mRequest = pRequest.getOperator(); 
		try {
			hbSession = HibernateUtils.getSessionFactory().openSession();
			Operators mExists = (Operators) hbSession.createCriteria(Operators.class).add(Restrictions.eq("name", mRequest.getName())).uniqueResult();
			if(mExists!=null && mRequest.getIdOperator()==0){
				mRes.setMSG_TYPE(Constants.MSG_TYPE_ERROR);
				mRes.setMessage("Could not find Operator in Database!");
			} else {
				if(mRequest.getIdOperator()!=mExists.getIdOperator()){
					mRes.setMSG_TYPE(Constants.MSG_TYPE_ERROR);
					mRes.setMessage("Invalid Operator ID!");
				} else {
					Operators mOperator = mExists;
					mOperator.setName(mRequest.getName());
					mOperator.setLocation(mRequest.getLocation());
					mOperator.setPhotoPath(mRequest.getPhotoPath());
					mRequest = mOperator;

					hbSession.beginTransaction();
					hbSession.saveOrUpdate(mRequest);
					hbSession.getTransaction().commit();
					mRes.setMSG_TYPE(Constants.MSG_TYPE_SUCCESS);
					mRes.setOperator(mRequest);
				}
			}
			return mRes;
		} catch(Exception ex){
			mRes.setMSG_TYPE(Constants.MSG_TYPE_ERROR);
			mRes.setMessage(ex.getMessage());
			return mRes;
		} finally {
			if (hbSession != null)
				hbSession.close();
		}
	}
	
	@GET
	@Path("/GetOperatorImage/{pUser}")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response GetOperatorImage(@PathParam("pUser") String pUser, @QueryParam("pImagePath") String pImagePath) {
	  try{
		File file = new File(pImagePath);
		return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
	      .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"" ) //optional
	      .build();
	  } catch (Exception ex){
		  return Response.status(404).build();
	  }
	}

	@GET
	@Path("/GetOperator/{pUser}/{pIdentifier}")
	@Produces("application/json")
	public ResponseOperator GetOperator(@PathParam("pUser") String pUser, @PathParam("pIdentifier") Integer pIdentifier) {
		log.debug("BEGIN--GetOperator pUser: " + pUser + "pIdentifier: " + pIdentifier.toString());
		Session hbSession = null;
		ResponseOperator mRes = new ResponseOperator();
		try {
			hbSession = HibernateUtils.getSessionFactory().openSession();
			Operators mResult = (Operators) hbSession.createCriteria(Operators.class).add(Restrictions.eq("idOperator",pIdentifier)).uniqueResult();
			if (mResult != null) {
				mResult.setOperatorOperations(null);
				mRes.setMSG_TYPE(Constants.MSG_TYPE_SUCCESS);
				mRes.setOperator(mResult);
			} else {
				mRes.setMSG_TYPE(Constants.MSG_TYPE_ERROR);
				mRes.setMessage("Could not find Operator in Database!");
			}
			return mRes;
		} catch(Exception ex){
			mRes.setMSG_TYPE(Constants.MSG_TYPE_ERROR);
			mRes.setMessage(ex.getMessage());
			return mRes;
		} finally {
			if (hbSession != null)
				hbSession.close();
		}
	}
	
	@GET
	@Path("/ListOperators/{pUser}")
	@Produces("application/json")
	public ResponseOperatorColl ListOperators(@PathParam("pUser") String pUser) {
		log.debug("BEGIN--ListOperators pUser: " + pUser);
		Session hbSession = null;
		ResponseOperatorColl mRes = new ResponseOperatorColl();
		try {
			hbSession = HibernateUtils.getSessionFactory().openSession();
			Collection<Operators> mResult = hbSession.createCriteria(Operators.class).list();
			if (mResult != null) {
				for(Operators op : mResult){
				    op.setOperatorOperations(null);
				}
				mRes.setMSG_TYPE(Constants.MSG_TYPE_SUCCESS);
				mRes.setOperators(mResult);
			} else {
				mRes.setMSG_TYPE(Constants.MSG_TYPE_ERROR);
				mRes.setMessage("Could not find Operators in Database!");
			}
			return mRes;
		} catch(Exception ex){
			mRes.setMSG_TYPE(Constants.MSG_TYPE_ERROR);
			mRes.setMessage(ex.getMessage());
			return mRes;
		} finally {
			if (hbSession != null)
				hbSession.close();
		}
	}
	
}
