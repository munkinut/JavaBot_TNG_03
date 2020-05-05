/*
 * ReplyHandlerInterface.java
 *
 * Created on 24 July 2002, 08:53
 */

package net.munki.irc.protocol.rfc2812;

public interface ReplyHandlerInterface {

    // 5.1 Command responses
    
    void RPL_WELCOME() throws ReplyHandlerException;    //001";
    void RPL_YOURHOST(String reply);    //002";
    void RPL_CREATED(String reply);    //003";
    void RPL_MYINFO(String reply);    //004";

    void RPL_BOUNCE(String reply);    //005";

    void RPL_USERHOST(String reply);    //302";
    
    void RPL_ISON(String reply);    //303";
    
    void RPL_AWAY(String reply);    //301";
    void RPL_UNAWAY(String reply);    //305";
    void RPL_NOWAWAY(String reply);    //306";
    
    void RPL_WHOISUSER(String reply);    //311";
    void RPL_WHOISSERVER(String reply);    //312";
    void RPL_WHOISOPERATOR(String reply);    //313";
    void RPL_WHOISIDLE(String reply);    //317";
    void RPL_ENDOFWHOIS(String reply);    //318";
    void RPL_WHOISCHANNELS(String reply);    //319";

    void RPL_WHOWASUSER(String reply);    //314";
    void RPL_ENDOFWHOWAS(String reply);    //369";

    void RPL_LISTSTART(String reply);    //321";
    void RPL_LIST(String reply);    //322";
    void RPL_LISTEND(String reply);    //323";

    void RPL_UNIQOPIS(String reply);    //325";
    void RPL_CHANNELMODEIS(String reply);    //324";
    void RPL_NOTOPIC(String reply);    //331";
    void RPL_TOPIC(String reply);    //332";

    void RPL_INVITING(String reply);    //341";

    void RPL_SUMMONING(String reply);    //342";

    void RPL_INVITELIST(String reply);    //346";
    void RPL_ENDOFINVITELIST(String reply);    //347";

    void RPL_EXCEPTLIST(String reply);    //348";
    void RPL_ENDOFEXCEPTLIST(String reply);    //349";

    void RPL_VERSION(String reply);    //351";

    void RPL_WHOREPLY(String reply);    //352";
    void RPL_ENDOFWHO(String reply);    //315";

    void RPL_NAMREPLY(String reply);    //353";
    void RPL_ENDOFNAMES(String reply);    //366";

    void RPL_LINKS(String reply);    //364";
    void RPL_ENDOFLINKS(String reply);    //365";

    void RPL_BANLIST(String reply);    //367";
    void RPL_ENDOFBANLIST(String reply);    //368";

    void RPL_INFO(String reply);    //371";
    void RPL_ENDOFINFO(String reply);    //374";

    void RPL_MOTDSTART(String reply);    //375";
    void RPL_MOTD(String reply);    //372";
    void RPL_ENDOFMOTD(String reply);    //"376";

    void RPL_YOUREOPER(String reply);    //381";

    void RPL_REHASHING(String reply);    //382";

    void RPL_YOURESERVICE(String reply);    //383";

    void RPL_TIME(String reply);    //391";

    void RPL_USERSSTART(String reply);    //392";
    void RPL_USERS(String reply);    //393";
    void RPL_ENDOFUSERS(String reply);    //394";
    void RPL_NOUSERS(String reply);    //395";

    void RPL_TRACELINK(String reply);    //200";
    void RPL_TRACECONNECTING(String reply);    //201";
    void RPL_TRACEHANDSHAKE(String reply);    //202";
    void RPL_TRACEUNKNOWN(String reply);    //203";
    void RPL_TRACEOPERATOR(String reply);    //204";
    void RPL_TRACEUSER(String reply);    //205";
    void RPL_TRACESERVER(String reply);    //206";
    void RPL_TRACESERVICE(String reply);    //207";
    void RPL_TRACENEWTYPE(String reply);    //208";
    void RPL_TRACECLASS(String reply);    //209";
    void RPL_TRACERECONNECT(String reply);    //210";
    void RPL_TRACELOG(String reply);    //261";
    void RPL_TRACEEND(String reply);    //262";

    void RPL_STATSLINKINFO(String reply);    //211";
    void RPL_STATSCOMMANDS(String reply);    //212";
    void RPL_ENDOFSTATS(String reply);    //219";
    void RPL_STATSUPTIME(String reply);    //242";
    void RPL_STATSOLINE(String reply);    //243";

    void RPL_UMODEIS(String reply);    //221";

    void RPL_SERVLIST(String reply);    //= "234";
    void RPL_SERVLISTEND(String reply);    //235";

    void RPL_LUSERCLIENT(String reply);    //251";
    void RPL_LUSEROP(String reply);    //252";
    void RPL_LUSERUNKNOWN(String reply);    //253";
    void RPL_LUSERCHANNELS(String reply);    //254";
    void RPL_LUSERME(String reply);    //255";

    void RPL_ADMINME(String reply);    //256";
    void RPL_ADMINLOC1(String reply);    //257";
    void RPL_ADMINLOC2(String reply);    //258";
    void RPL_ADMINEMAIL(String reply);    //259";

    void RPL_TRYAGAIN(String reply);    //263";
    
    // 5.2 Error Replies
    
    void ERR_NOSUCHNICK(String reply);    //401";
    void ERR_NOSUCHSERVER(String reply);    //402";
    void ERR_NOSUCHCHANNEL(String reply);    //403";
    void ERR_CANNOTSENDTOCHAN(String reply);    //404";
    void ERR_TOOMANYCHANNELS(String reply);    //405";
    void ERR_WASNOSUCHNICK(String reply);    //406";
    void ERR_TOOMANYTARGETS(String reply);    //407";
    void ERR_NOSUCHSERVICE(String reply);    //408";
    void ERR_NOORIGIN(String reply);    //409";
    
    void ERR_NORECIPIENT(String reply);    //411";
    void ERR_NOTEXTTOSEND(String reply);    //412";
    void ERR_NOTOPLEVEL(String reply);    //413";
    void ERR_WILDTOPLEVEL(String reply);    //414";
    void ERR_BADMASK(String reply);    //415";

    void ERR_UNKNOWNCOMMAND(String reply);    //421";
    void ERR_NOMOTD(String reply);    //422";
    void ERR_NOADMININFO(String reply);    //423";
    void ERR_FILEERROR(String reply);    //424";

    void ERR_NONICKNAMEGIVEN(String reply);    //431";
    void ERR_ERRONEUSNICKNAME(String reply);    //432";
    void ERR_NICKNAMEINUSE() throws ReplyHandlerException;    //433";

    void ERR_NICKCOLLISION(String reply);    //436";
    void ERR_UNAVAILRESOURCE(String reply);    //437";

    void ERR_USERNOTINCHANNEL(String reply);    //441";
    void ERR_NOTONCHANNEL(String reply);    //442";
    void ERR_USERONCHANNEL(String reply);    //443";
    void ERR_NOLOGIN(String reply);    //444";
    void ERR_SUMMONDISABLED(String reply);    //445";
    void ERR_USERSDISABLED(String reply);    //446";

    void ERR_NOTREGISTERED(String reply);    //451";

    void ERR_NEEDMOREPARAMS(String reply);    //461";
    void ERR_ALREADYREGISTERED(String reply);    //462";
    void ERR_NOPERMFORHOST(String reply);    //463";
    void ERR_PASSWDMISMATCH(String reply);    //464";
    void ERR_YOUREBANNEDCREEP(String reply);    //465";
    void ERR_YOUWILLBEBANNED(String reply);    //466";
    void ERR_KEYSET(String reply);    //467";

    void ERR_CHANNELISFULL(String reply);    //471";
    void ERR_UNKNOWNMODE(String reply);    //472";
    void ERR_INVITEONLYCHAN(String reply);    //473";
    void ERR_BANNEDFROMCHAN(String reply);    //474";
    void ERR_BADCHANNELKEY(String reply);    //475";
    void ERR_BADCHANMASK(String reply);    //476";
    void ERR_NOCHANMODES(String reply);    //477";
    void ERR_BANLISTFULL(String reply);    //478";

    void ERR_NOPRIVILEGES(String reply);    //481";
    void ERR_CHANOPRIVSNEEDED(String reply);    //482";
    void ERR_CANTKILLSERVER(String reply);    //483";
    void ERR_RESTRICTED(String reply);    //484";
    void ERR_UNIQOPPRIVSNEEDED(String reply);    //485";

    void ERR_NOOPERHOST(String reply);    //491";

    void ERR_UMODEUNKNOWNFLAG(String reply);    //501";
    void ERR_USERSDONTMATCH(String reply);    //502";
    
    // 5.3 Reserved numerics
    
    void RPL_SERVICEINFO(String reply);    //231";
    void RPL_ENDOFSERVICES(String reply);    //232";
    void RPL_SERVICE(String reply);    //233";

    void RPL_NONE(String reply);    //300";

    void RPL_WHOISCHANOP(String reply);    //316";

    void RPL_KILLDONE(String reply);    //361";
    void RPL_CLOSING(String reply);    //362";
    void RPL_CLOSEEND(String reply);    //363";

    void RPL_INFOSTART(String reply);    //373";

    void RPL_MYPORTIS(String reply);    //384";

    void RPL_STATSCLINE(String reply);    //213";
    void RPL_STATSNLINE(String reply);    //214";
    void RPL_STATSILINE(String reply);    //215";
    void RPL_STATSKLINE(String reply);    //216";
    void RPL_STATSQLINE(String reply);    //217";
    void RPL_STATSYLINE(String reply);    //218";

    void RPL_STATSVLINE(String reply);    //240";
    void RPL_STATSLLINE(String reply);    //241";

    void RPL_STATSHLINE(String reply);    //244";
    void RPL_STATSSLINE(String reply);    //245";
    void RPL_STATSPING(String reply);    //246";
    void RPL_STATSBLINE(String reply);    //247";

    void RPL_STATSDLINE(String reply);    //250";
}

