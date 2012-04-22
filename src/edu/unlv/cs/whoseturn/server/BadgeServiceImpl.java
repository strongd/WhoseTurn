package edu.unlv.cs.whoseturn.server;

import java.util.List;
import java.util.Set;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.unlv.cs.whoseturn.client.BadgeService;
import edu.unlv.cs.whoseturn.domain.BadgeAwarded;
import edu.unlv.cs.whoseturn.domain.PMF;
import edu.unlv.cs.whoseturn.domain.Turn;
import edu.unlv.cs.whoseturn.domain.TurnItem;
import edu.unlv.cs.whoseturn.domain.User;

/**
 * The badge service, used to associating and reading badges a user has.
 */
public class BadgeServiceImpl extends RemoteServiceServlet implements BadgeService {

	/**
	 * Allows the class to be serialized.
	 */
	private static final long serialVersionUID = 3341571143301810951L;
	
	/**
	 * Persistence Manager, used for CRUD with the db.
	 */
	PersistenceManager pm = PMF.get().getPersistenceManager();

	@Override
	public void Jackass(Turn turn) {
		Set<String> turn_items = turn.getTurnItems();

		// get the keys of the turn items
		for (String turn_key : turn_items) {
			Key turnItemKey = KeyFactory.stringToKey(turn_key);
			TurnItem turn_item = pm.getObjectById(TurnItem.class, turnItemKey);
			// get the key of the user who owns this turn item and then get the
			// user
			Key ownerKey = KeyFactory.stringToKey(turn_item.getOwnerKeyString());
			User user = pm.getObjectById(User.class, ownerKey);
			Set<String> badgeSet = user.getBadges();

			// Jackass badge check
			if (turn.getNumberOfUsers() == 1) {
				for (int i = 0; i < badgeSet.size(); i++) {
					// get key for the BadgeAwarded entity and retrieve the
					// object
					Key badgeKey = KeyFactory.stringToKey(badgeSet.iterator().next());
					BadgeAwarded badge = pm.getObjectById(BadgeAwarded.class, badgeKey);

					if (badge.getBadgeId().equals(1000)) {
						badge.increaseBadgeCount();
						break;
					}
				}
			}
		}

		pm.close();
	}

	@Override
	public void TeamCheater(Turn turn) {
		;
	}

	@Override
	public void CornerStone(Turn turn) {
		Set<String> turn_items = turn.getTurnItems();

		// get the keys of the turn items
		for (String turn_key : turn_items) {
			Key turnItemKey = KeyFactory.stringToKey(turn_key);
			TurnItem turn_item = pm.getObjectById(TurnItem.class, turnItemKey);
			// get the key of the user who owns this turn item and then get the
			// user
			Key ownerKey = KeyFactory.stringToKey(turn_item.getOwnerKeyString());
			User user = pm.getObjectById(User.class, ownerKey);
			Set<String> badgeSet = user.getBadges();

			// Badge Check
			if (turn.getNumberOfUsers() == 4) {
				// Corner Stone badge
				if (turn_item.getSelected()) {
					for (int i = 0; i < badgeSet.size(); i++) {
						// get key for the BadgeAwarded entity and retrieve the
						// object
						Key badgeKey = KeyFactory.stringToKey(badgeSet.iterator().next());
						BadgeAwarded badge = pm.getObjectById(BadgeAwarded.class, badgeKey);

						if (badge.getBadgeId().equals(1001)) {
							badge.increaseBadgeCount();
							break;
						}
					}
				}
				// Don't Cross The Streams badge
				if (!turn_item.getSelected()) {
					for (int i = 0; i < badgeSet.size(); i++) {
						/**
						 * Get key for the BadgeAwarded entity and retrieve the object.
						 */
						Key badgeKey = KeyFactory.stringToKey(badgeSet.iterator().next());
						BadgeAwarded badge = pm.getObjectById(BadgeAwarded.class, badgeKey);

						if (badge.getBadgeId().equals(1002)) {
							badge.increaseBadgeCount();
							break;
						}
					}
				}
			}
		}

		pm.close();
	}

	@Override
	public void HumanSacrifice(Turn turn) {
		Set<String> turn_items = turn.getTurnItems();

		// get the keys of the turn items
		for (String turn_key : turn_items) {
			Key turnItemKey = KeyFactory.stringToKey(turn_key);
			TurnItem turn_item = pm.getObjectById(TurnItem.class, turnItemKey);
			/**
			 * Get the key of the user who owns this turn item and then get the user.
			 */
			Key ownerKey = KeyFactory.stringToKey(turn_item.getOwnerKeyString());
			User user = pm.getObjectById(User.class, ownerKey);
			Set<String> badgeSet = user.getBadges();

			// Badge Check
			if (turn.getNumberOfUsers() == 5) {
				// Human Sacrifice badge
				if (turn_item.getSelected()) {
					for (int i = 0; i < badgeSet.size(); i++) {
						// get key for the BadgeAwarded entity and retrieve the
						// object
						Key badgeKey = KeyFactory.stringToKey(badgeSet.iterator().next());
						BadgeAwarded badge = pm.getObjectById(BadgeAwarded.class, badgeKey);

						if (badge.getBadgeId().equals(1003)) {
							badge.increaseBadgeCount();
							break;
						}
					}
				}
				// Not The Thumb badge
				if (!turn_item.getSelected()) {
					for (int i = 0; i < badgeSet.size(); i++) {
						// get key for the BadgeAwarded entity and retrieve the
						// object
						Key badgeKey = KeyFactory.stringToKey(badgeSet.iterator().next());
						BadgeAwarded badge = pm.getObjectById(BadgeAwarded.class, badgeKey);

						if (badge.getBadgeId().equals(1004)) {
							badge.increaseBadgeCount();
							break;
						}
					}
				}
			}
		}

		pm.close();
	}

	@Override
	public void SixMinuteAbs(Turn turn) {
		Set<String> turn_items = turn.getTurnItems();

		// get the keys of the turn items
		for (String turn_key : turn_items) {
			Key turnItemKey = KeyFactory.stringToKey(turn_key);
			TurnItem turn_item = pm.getObjectById(TurnItem.class, turnItemKey);
			// get the key of the user who owns this turn item and then get the
			// user
			Key ownerKey = KeyFactory.stringToKey(turn_item.getOwnerKeyString());
			User user = pm.getObjectById(User.class, ownerKey);
			Set<String> badgeSet = user.getBadges();

			// Badge Check
			if (turn.getNumberOfUsers() == 6) {
				// Six Minute Abs badge
				if (turn_item.getSelected()) {
					for (int i = 0; i < badgeSet.size(); i++) {
						/**
						 * Get key for the BadgeAwarded entity and retrieve the object.
						 */
						Key badgeKey = KeyFactory.stringToKey(badgeSet.iterator().next());
						BadgeAwarded badge = pm.getObjectById(BadgeAwarded.class, badgeKey);

						if (badge.getBadgeId().equals(1005)) {
							badge.increaseBadgeCount();
							break;
						}
					}
				}
				// Pick Up Sticks badge
				if (!turn_item.getSelected()) {
					for (int i = 0; i < badgeSet.size(); i++) {
						/**
						 * Get key for the BadgeAwarded entity and retrieve the object.
						 */
						Key badgeKey = KeyFactory.stringToKey(badgeSet.iterator().next());
						BadgeAwarded badge = pm.getObjectById(BadgeAwarded.class, badgeKey);

						if (badge.getBadgeId().equals(1006)) {
							badge.increaseBadgeCount();
							break;
						}
					}
				}
			}
		}

		pm.close();
	}

	@Override
	public void CrappedOut(Turn turn) {
		Set<String> turn_items = turn.getTurnItems();

		// get the keys of the turn items
		for (String turn_key : turn_items) {
			Key turnItemKey = KeyFactory.stringToKey(turn_key);
			TurnItem turn_item = pm.getObjectById(TurnItem.class, turnItemKey);
			// get the key of the user who owns this turn item and then get the
			// user
			Key ownerKey = KeyFactory.stringToKey(turn_item.getOwnerKeyString());
			User user = pm.getObjectById(User.class, ownerKey);
			Set<String> badgeSet = user.getBadges();

			// Badge Check
			if (turn.getNumberOfUsers() == 7) {
				// Crapped Out badge
				if (turn_item.getSelected()) {
					for (int i = 0; i < badgeSet.size(); i++) {
						/**
						 * Get key for the BadgeAwarded entity and retrieve the object.
						 */
						Key badgeKey = KeyFactory.stringToKey(badgeSet.iterator().next());
						BadgeAwarded badge = pm.getObjectById(BadgeAwarded.class, badgeKey);

						if (badge.getBadgeId().equals(1007)) {
							badge.increaseBadgeCount();
							break;
						}
					}
				}
				// Lucky No. 7 badge
				if (!turn_item.getSelected()) {
					for (int i = 0; i < badgeSet.size(); i++) {
						// get key for the BadgeAwarded entity and retrieve the
						// object
						Key badgeKey = KeyFactory.stringToKey(badgeSet.iterator().next());
						BadgeAwarded badge = pm.getObjectById(BadgeAwarded.class, badgeKey);

						if (badge.getBadgeId().equals(1008)) {
							badge.increaseBadgeCount();
							break;
						}
					}
				}
			}
		}

		pm.close();
	}

	@Override
	public void SnowWhite(Turn turn) {
		Set<String> turn_items = turn.getTurnItems();

		// get the keys of the turn items
		for (String turn_key : turn_items) {
			Key turnItemKey = KeyFactory.stringToKey(turn_key);
			TurnItem turn_item = pm.getObjectById(TurnItem.class, turnItemKey);
			// get the key of the user who owns this turn item and then get the
			// user
			Key ownerKey = KeyFactory.stringToKey(turn_item.getOwnerKeyString());
			User user = pm.getObjectById(User.class, ownerKey);
			Set<String> badgeSet = user.getBadges();

			// Badge Check
			if (turn.getNumberOfUsers() == 8) {
				// Snow White badge
				if (turn_item.getSelected()) {
					for (int i = 0; i < badgeSet.size(); i++) {
						// get key for the BadgeAwarded entity and retrieve the
						// object
						Key badgeKey = KeyFactory.stringToKey(badgeSet.iterator().next());
						BadgeAwarded badge = pm.getObjectById(BadgeAwarded.class, badgeKey);

						if (badge.getBadgeId().equals(1009)) {
							badge.increaseBadgeCount();
							break;
						}
					}
				}
				// Dwarf badge
				if (!turn_item.getSelected()) {
					for (int i = 0; i < badgeSet.size(); i++) {
						// get key for the BadgeAwarded entity and retrieve the
						// object
						Key badgeKey = KeyFactory.stringToKey(badgeSet.iterator().next());
						BadgeAwarded badge = pm.getObjectById(BadgeAwarded.class, badgeKey);

						if (badge.getBadgeId().equals(1010)) {
							badge.increaseBadgeCount();
							break;
						}
					}
				}
			}
		}

		pm.close();
	}

	@Override
	public void FML(Turn turn) {
		Set<String> turn_items = turn.getTurnItems();

		// get the keys of the turn items
		for (String turn_key : turn_items) {
			Key turnItemKey = KeyFactory.stringToKey(turn_key);
			TurnItem turn_item = pm.getObjectById(TurnItem.class, turnItemKey);
			// get the key of the user who owns this turn item
			Key ownerKey = KeyFactory.stringToKey(turn_item.getOwnerKeyString());
			User user = pm.getObjectById(User.class, ownerKey);
			Set<String> badgeSet = user.getBadges();

			// Badge Check
			if (turn.getNumberOfUsers() > 8) {
				// FML badge
				if (turn_item.getSelected()) {
					for (int i = 0; i < badgeSet.size(); i++) {
						// get key for the BadgeAwarded entity and retrieve the
						// object
						Key badgeKey = KeyFactory.stringToKey(badgeSet.iterator().next());
						BadgeAwarded badge = pm.getObjectById(BadgeAwarded.class, badgeKey);

						if (badge.getBadgeId().equals(1011)) {
							badge.increaseBadgeCount();
							break;
						}
					}
				}
				// Statistically Speaking badge
				if (!turn_item.getSelected()) {
					for (int i = 0; i < badgeSet.size(); i++) {
						// get key for the BadgeAwarded entity and retrieve the
						// object
						Key badgeKey = KeyFactory.stringToKey(badgeSet.iterator().next());
						BadgeAwarded badge = pm.getObjectById(BadgeAwarded.class, badgeKey);

						if (badge.getBadgeId().equals(1012)) {
							badge.increaseBadgeCount();
							break;
						}
					}
				}
			}
		}

		pm.close();
	}

	@Override
	public void Saint(User user) {
		Integer countTurns = user.getTurnItems().size();
		Set<String> badgeSet = user.getBadges();

		if (countTurns >= 50) {
			for (int i = 0; i < badgeSet.size(); i++) {
				// get key for the BadgeAwarded entity and retrieve the object
				Key badgeKey = KeyFactory.stringToKey(badgeSet.iterator().next());
				BadgeAwarded userBadge = pm.getObjectById(BadgeAwarded.class, badgeKey);

				if (userBadge.getBadgeId().equals(1013)) {
					// check if user does not have any liar badges
					// if true, award Saint badge
					if (userBadge.getCount().equals(0)) {
						userBadge.increaseBadgeCount();
						break;
					}
				}
			}
		}

		pm.close();
	}

	@Override
	public void Socialite(Turn turn) {
		Integer number_of_users = turn.getNumberOfUsers();

		if (number_of_users > 10) {
			for (String turnItemKeyString : turn.getTurnItems()) {
				// get key for the TurnItem and retrieve the object
				Key turnItemKey = KeyFactory.stringToKey(turnItemKeyString);
				TurnItem turnItem = pm.getObjectById(TurnItem.class, turnItemKey);
				// get key for user of the turn item, and then get the user
				String ownerKeyString = turnItem.getOwnerKeyString();
				Key ownerKey = KeyFactory.stringToKey(ownerKeyString);
				User user = pm.getObjectById(User.class, ownerKey);
				Set<String> badgeSet = user.getBadges();

				for (int i = 0; i < badgeSet.size(); i++) {
					// get key for the BadgeAwarded entity and retrieve the
					// object
					Key badgeKey = KeyFactory.stringToKey(badgeSet.iterator().next());
					BadgeAwarded badge = pm.getObjectById(BadgeAwarded.class, badgeKey);

					if (badge.getBadgeId().equals(1014)) {
						badge.increaseBadgeCount();
						break;
					}
				}
			}
		}
	}

	@Override
	public void StormShadow(User user) {
		Set<String> badgeSet = user.getBadges();

		if (user.getUsername().equals("Chris Jones")) {
			for (int i = 0; i < badgeSet.size(); i++) {
				/**
				 * Get key for the BadgeAwarded entity and retrieve the object
				 */
				Key badgeKey = KeyFactory.stringToKey(badgeSet.iterator().next());
				BadgeAwarded userBadge = pm.getObjectById(BadgeAwarded.class, badgeKey);

				if (userBadge.getBadgeId().equals(1020)) {
					userBadge.increaseBadgeCount();
					break;
				}
			}
		}
	}

	@Override
	public void MythBusters(User user) {
		Set<String> badgeSet = user.getBadges();
		if (user.getUsername().equals("Matthew Sowders")) {
			for (int i = 0; i < badgeSet.size(); i++) {
				// get key for the BadgeAwarded entity and retrieve the object
				Key badgeKey = KeyFactory.stringToKey(badgeSet.iterator().next());
				BadgeAwarded userBadge = pm.getObjectById(BadgeAwarded.class, badgeKey);

				if (userBadge.getBadgeId().equals(1021)) {
					userBadge.increaseBadgeCount();
					break;
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void calculateBadges(Turn turn) {
		/**
		 * Retrieve a list of all users in the database for badge calculation.
		 */
		Query query = pm.newQuery(edu.unlv.cs.whoseturn.domain.User.class);
		List<edu.unlv.cs.whoseturn.domain.User> userList;

		try {
			userList = (List<edu.unlv.cs.whoseturn.domain.User>) query.execute();
		} finally {
			query.closeAll();
			pm.close();
		}

		// Initiate badge calculation based on the turn submitted.
		Jackass(turn);
		TeamCheater(turn);
		CornerStone(turn);
		HumanSacrifice(turn);
		SixMinuteAbs(turn);
		CrappedOut(turn);
		SnowWhite(turn);
		FML(turn);
		Socialite(turn);

		// Initiate badge calculation for the users.
		for (User user : userList) {
			Saint(user);
			StormShadow(user);
			MythBusters(user);
		}
	}

}
